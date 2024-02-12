package br.uem.geolocalizacao.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.uem.geolocalizacao.model.Geolocalizacao;
import br.uem.geolocalizacao.service.impl.GeolocalizacaoServiceImpl;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/geolocalizacao")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GeolocalizacaoController {

    @Autowired
    private GeolocalizacaoServiceImpl service;

    private final OkHttpClient httpClient = new OkHttpClient();

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Geolocalizacao getGeolocalizacao(@RequestParam String query) throws JSONException {
        Geolocalizacao geolocalizacao = new Geolocalizacao();

        JSONObject retorno;
        try {
            retorno = this.searchGeo(query.replace(" ", "+"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(retorno != null) {
            geolocalizacao.setLongitude(retorno.getString("lon"));
            geolocalizacao.setLatitude(retorno.getString("lat"));
        }
        else {
            geolocalizacao.setLongitude("error");
            geolocalizacao.setLatitude("error");
        }

        return geolocalizacao;
    }

    @NotNull
    public JSONObject searchGeo(String query) throws IOException {
        Request request = new Request.Builder()
                .url("https://nominatim.openstreetmap.org/?q=" + query + "&format=json&limit=1")
                .build();

        System.out.println(request);

        try (okhttp3.Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            JSONArray jsonArray = new JSONArray(response.body().string());

            if(jsonArray.length() > 0) {
                return jsonArray.getJSONObject(0);
            }

            return null;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
