/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushohenshu.KaigoAtesakiJushoHenshu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.JushoHenshuChoikiHenshuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.JushoHenshuGunHyojiUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.JushoHenshuKatagakiHyojiUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.JushoHenshuShichosonHyojiUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.JushoHenshuTodofukenHyojiUmu;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 介護住所編集方法ダイアログのHandlerです。
 *
 * @reamsid_L DBA-1201-050 yaodongsheng
 */
public class KaigoAtesakiJushoHenshuHandler {

    private final KaigoAtesakiJushoHenshuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KaigoAtesakiJushoHenshuDiv
     */
    public KaigoAtesakiJushoHenshuHandler(KaigoAtesakiJushoHenshuDiv div) {
        this.div = div;
    }

    /**
     * 介護住所編集方法ダイアログのinitlizeです。
     */
    public void initlize() {
        setDatasource();
        div.getRadKenmeiHyojiUmu().setSelectedKey(div.getHdnTodofukenMei());
        div.getRadGunmeiHyojiUmu().setSelectedKey(div.getHdnGunMei());
        div.getRadCitymeiHyojiUmu().setSelectedKey(div.getHdnShichosonMei());
        div.getDdlChoikiHenshu().setSelectedKey(div.getHdnHensyuHoho());
        div.getRadKatagakiHyojiUmu().setSelectedKey(div.getHdnKatagaki());
    }

    private void setDatasource() {
        List<KeyValueDataSource> kenmeihyoList = new ArrayList<>();
        for (JushoHenshuTodofukenHyojiUmu jushoHenshuTodofukenHyojiUmu : JushoHenshuTodofukenHyojiUmu.values()) {
            KeyValueDataSource kenmeihyo = new KeyValueDataSource();
            kenmeihyo.setKey(jushoHenshuTodofukenHyojiUmu.getコード());
            kenmeihyo.setValue(jushoHenshuTodofukenHyojiUmu.get名称());
            kenmeihyoList.add(kenmeihyo);
        }
        Collections.sort(kenmeihyoList, new DateComparator());
        div.getRadKenmeiHyojiUmu().setDataSource(kenmeihyoList);
        List<KeyValueDataSource> gunmeiHyoList = new ArrayList<>();
        for (JushoHenshuGunHyojiUmu jushoHenshuGunHyojiUmu : JushoHenshuGunHyojiUmu.values()) {
            KeyValueDataSource gunmeiHyo = new KeyValueDataSource();
            gunmeiHyo.setKey(jushoHenshuGunHyojiUmu.getコード());
            gunmeiHyo.setValue(jushoHenshuGunHyojiUmu.get名称());
            gunmeiHyoList.add(gunmeiHyo);
        }
        Collections.sort(gunmeiHyoList, new DateComparator());
        div.getRadGunmeiHyojiUmu().setDataSource(gunmeiHyoList);
        List<KeyValueDataSource> citymeiList = new ArrayList<>();
        for (JushoHenshuShichosonHyojiUmu jushoHenshuShichosonHyojiUmu : JushoHenshuShichosonHyojiUmu.values()) {
            KeyValueDataSource citymei = new KeyValueDataSource();
            citymei.setKey(jushoHenshuShichosonHyojiUmu.getコード());
            citymei.setValue(jushoHenshuShichosonHyojiUmu.get名称());
            citymeiList.add(citymei);
        }
        Collections.sort(citymeiList, new DateComparator());
        div.getRadCitymeiHyojiUmu().setDataSource(citymeiList);
        List<KeyValueDataSource> choikiHenshuList = new ArrayList<>();
        for (JushoHenshuChoikiHenshuHoho jushoHenshuChoikiHenshuHoho : JushoHenshuChoikiHenshuHoho.values()) {
            KeyValueDataSource choikiHenshu = new KeyValueDataSource();
            choikiHenshu.setKey(jushoHenshuChoikiHenshuHoho.getコード());
            choikiHenshu.setValue(jushoHenshuChoikiHenshuHoho.get略称());
            choikiHenshuList.add(choikiHenshu);
        }
        Collections.sort(choikiHenshuList, new DateComparator());
        div.getDdlChoikiHenshu().setDataSource(choikiHenshuList);
        List<KeyValueDataSource> katagakiHyoList = new ArrayList<>();
        for (JushoHenshuKatagakiHyojiUmu jushoHenshuKatagakiHyojiUmu : JushoHenshuKatagakiHyojiUmu.values()) {
            KeyValueDataSource katagakiHyo = new KeyValueDataSource();
            katagakiHyo.setKey(jushoHenshuKatagakiHyojiUmu.getコード());
            katagakiHyo.setValue(jushoHenshuKatagakiHyojiUmu.get名称());
            katagakiHyoList.add(katagakiHyo);
        }
        Collections.sort(katagakiHyoList, new DateComparator());
        div.getRadKatagakiHyojiUmu().setDataSource(katagakiHyoList);
    }

    private static class DateComparator implements Comparator<KeyValueDataSource>, Serializable {

        @Override
        public int compare(KeyValueDataSource o1, KeyValueDataSource o2) {
            return o2.getKey().compareTo(o1.getKey());
        }
    }
}
