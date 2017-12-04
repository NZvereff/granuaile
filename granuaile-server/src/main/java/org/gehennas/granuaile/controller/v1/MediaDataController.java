package org.gehennas.granuaile.controller.v1;

import org.gehennas.granuaile.controller.exceptions.ResourceNotFoundException;
import org.gehennas.granuaile.model.TrackData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/media")
public class MediaDataController {

    private static final TrackData dummy = new TrackData(0,"Unknown Track", "Unknown Album", 2000, "Unknown Artist");

    @RequestMapping(value = "/track", method = RequestMethod.GET)
    public TrackData getTrackData(@RequestParam(value="id", defaultValue = "0") int id) {
        if (id==0) {
            return dummy;
        } else {
            throw new ResourceNotFoundException();
        }
    }

}
