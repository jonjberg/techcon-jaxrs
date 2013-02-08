
@XmlJavaTypeAdapter(value=UTCDateAdapter.class,type=Date.class)
package com.nationwide.techcon.models;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.nationwide.techcon.models.adapters.UTCDateAdapter;
