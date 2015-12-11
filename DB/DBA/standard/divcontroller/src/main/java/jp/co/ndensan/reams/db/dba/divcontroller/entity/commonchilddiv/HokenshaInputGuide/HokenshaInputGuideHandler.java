/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaInputGuide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.Hokensha;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.KenCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.HokenshaModel;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hokensha.HokenshaMapperParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * {@link HokenshaInputGuideDiv}のHandlerクラスです。
 */
public class HokenshaInputGuideHandler {

    private final HokenshaInputGuideDiv div;
    private RString kenCode;

    public HokenshaInputGuideHandler(HokenshaInputGuideDiv div) {
        this.div = div;
    }

    public ResponseData<HokenshaJohoDiv> on保険者検索(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaJohoDiv> responseData = new ResponseData<>();
//        HokenshaModel serviceType = DataPassingConverter.deserialize(div.getHokenshaModel(), HokenshaModel.class);
        if (div.getHokenshaNo().isEmpty()) {
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            kenCode = new RString(association.get地方公共団体コード().toString());
            kenCode = association.get市町村名();
            kenCode = new RString("11");
        } else {
            kenCode = new RString(div.getHokenshaNo().toString().substring(0, 2));
        }
        set保険者(div, kenCode);
        clear();
        List<KenCodeJigyoshaInputGuide> KenCodeList = HokenshaNyuryokuHojoFinder.createInstance().getKenCodeJigyoshaInputGuide();
        List<KeyValueDataSource> list = new ArrayList<>();
        for (KenCodeJigyoshaInputGuide guide : KenCodeList) {
            KeyValueDataSource DataSource = new KeyValueDataSource();
            DataSource.setKey(guide.get都道府県住所コード());
            DataSource.setValue(guide.get都道府県名());
            list.add(DataSource);
        }
        return responseData;
    }

    public ResponseData<HokenshaJohoDiv> on保険者を表示する(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaJohoDiv> responseData = new ResponseData<>();
        kenCode = div.getDdlHokenshaKenCode().getSelectedKey();
        set保険者(div, kenCode);
        return responseData;
    }

    public ResponseData<HokenshaJohoDiv> on選択(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaJohoDiv> responseData = new ResponseData<>();
        dgSearchResultHokensha_Row row = div.getSearchResultHokensha().getDgSearchResultHokensha().getActiveRow();
        HokenshaModel serviceType = new HokenshaModel();
        serviceType.set保険者コード(row.getHokenshaNo());
        serviceType.set保険者名(row.getHokenshaMeisho());
        div.setHokenshaModel(DataPassingConverter.serialize(serviceType));
        return responseData;
    }

    private void set保険者(HokenshaInputGuideDiv div, RString kenCode) {
        HokenshaMapperParameter parameter = HokenshaMapperParameter.createKenCodeParam(kenCode);
        List<Hokensha> hokenjaList = HokenshaNyuryokuHojoFinder.createInstance().getHokenshaList(parameter);
        List<dgSearchResultHokensha_Row> list = new ArrayList<>();
        for (Hokensha guide : hokenjaList) {
            dgSearchResultHokensha_Row row = new dgSearchResultHokensha_Row();
            row.setHokenshaMeisho(guide.get保険者名());
            row.setHokenshaNo(new RString("111111"));
            row.setHokensha(new RString("111111"));
            list.add(row);
        }
        div.getSearchResultHokensha().getDgSearchResultHokensha().setDataSource(list);
    }

    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void clear() {
        div.getDdlHokenshaKenCode().getDataSource().clear();
    }
}
