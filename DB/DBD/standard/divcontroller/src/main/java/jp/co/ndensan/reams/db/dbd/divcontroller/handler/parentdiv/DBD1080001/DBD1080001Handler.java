/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1080001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.RiyoshaFutanDankaiHanni;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd1080001.ShinseishoHakkoTaishoshaHaakuParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080001.ShinseishoHakkoTaishoshaHaakuParameterMainDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBDGM12021_1_減免減額申請書発行用対象者把握のHandlerクラスです。
 *
 * @reamsid_L DBD-3530-010 liuwei2
 */
public class DBD1080001Handler {

    private final ShinseishoHakkoTaishoshaHaakuParameterMainDiv taishoshaHaakuMainDiv;
    private RString code;
    private final RString KEY_TWO = new RString("key2");

    /**
     * コンストラクタです。
     *
     * @param taishoshaHaakuMainDiv ShinseishoHakkoTaishoshaHaakuParameterMainDiv
     */
    public DBD1080001Handler(ShinseishoHakkoTaishoshaHaakuParameterMainDiv taishoshaHaakuMainDiv) {
        this.taishoshaHaakuMainDiv = taishoshaHaakuMainDiv;
    }

    /**
     * 画面の初期化処理処理です。
     *
     * @param div ShinseishoHakkoTaishoshaHaakuParameterMainDiv
     * @return ResponseData
     */
    public ResponseData onload(ShinseishoHakkoTaishoshaHaakuParameterMainDiv div) {
        ResponseData responseData = new ResponseData<>();
        div.getParameters().getRadShinkiKoshiKubun().setSelectedKey(KEY_TWO);

        setDataSource(div.getParameters().getDdlGemmenGengakuShrui().getDataSource(),
                new RString("key1"), new RString("利用者負担額減額"));
        setDataSource(div.getParameters().getDdlGemmenGengakuShrui().getDataSource(),
                new RString("key2"), new RString("訪問介護利用者負担額減額"));
        setDataSource(div.getParameters().getDdlGemmenGengakuShrui().getDataSource(),
                new RString("key3"), new RString("社会福祉法人等利用者負担軽減"));

        FlexibleDate 基準日 = new FlexibleDate(new RString(RDate.getNowDate().toString()));
        div.getParameters().getTxtKijunYMD().setValue(基準日);

        HizukeConfig config = new HizukeConfig();
        FlexibleYear 所得年度 = config.get所得年度();
        div.getParameters().getTxtShotokuNendo().setDomain(所得年度);

        setDataSource(div.getParameters().getDdlKyushochishaKubun1().getDataSource(),
                new RString("key1"), new RString("旧措置者以外"));
        setDataSource(div.getParameters().getDdlKyushochishaKubun1().getDataSource(),
                new RString("key2"), new RString("旧措置者"));

        div.getParameters().getRadShisetsuNyushoKubun1().setSelectedKey(new RString("key0"));

        setDataSource(div.getParameters().getDdlRiyoshaFutanDankai().getDataSource(),
                new RString("key1"), new RString("利用者負担1段階"));
        setDataSource(div.getParameters().getDdlRiyoshaFutanDankai().getDataSource(),
                new RString("key2"), new RString("利用者負担2段階"));
        setDataSource(div.getParameters().getDdlRiyoshaFutanDankai().getDataSource(),
                new RString("key3"), new RString("利用者負担3段階"));
        setDataSource(div.getParameters().getDdlRiyoshaFutanDankai().getDataSource(),
                new RString("key4"), new RString("利用者負担4段階（高齢者複数世帯）"));
        responseData.data = div;
        return responseData;
    }

    /**
     * 画面側からバッチパラメータを取得します。
     *
     * @return ShinseishoHakkoTaishoshaHaakuParameter parameter
     */
    public ShinseishoHakkoTaishoshaHaakuParameter getParameter() {
        ShinseishoHakkoTaishoshaHaakuParameter parameter = new ShinseishoHakkoTaishoshaHaakuParameter();
        RString 新規更新区分 = taishoshaHaakuMainDiv.getParameters().getRadShinkiKoshiKubun().getSelectedValue();
        boolean 課税世帯の被保険者を含む = taishoshaHaakuMainDiv.getParameters().getChkContainsKazeiHihokensha().getSelectedValues().contains(new RString("課税世帯の被保険者を含む"));

        if (taishoshaHaakuMainDiv.getParameters().getDdlGemmenGengakuShrui().getSelectedValue().equals(GemmenGengakuShurui.負担限度額認定.get名称())) {
            code = GemmenGengakuShurui.負担限度額認定.getコード();
        } else if (taishoshaHaakuMainDiv.getParameters().getDdlGemmenGengakuShrui().getSelectedValue().equals(GemmenGengakuShurui.利用者負担額減額.get名称())) {
            code = GemmenGengakuShurui.利用者負担額減額.getコード();
        } else if (taishoshaHaakuMainDiv.getParameters().getDdlGemmenGengakuShrui().getSelectedValue().equals(GemmenGengakuShurui.訪問介護利用者負担額減額.get名称())) {
            code = GemmenGengakuShurui.訪問介護利用者負担額減額.getコード();
        } else {
            code = GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード();
        }
        GemmenGengakuShurui 減免減額種類 = GemmenGengakuShurui.toValue(code);

        if (減免減額種類.get名称().equals(new RString("負担限度額認定"))) {
            RString 旧措置区分1 = taishoshaHaakuMainDiv.getParameters().getDdlKyushochishaKubun1().getSelectedValue();
            parameter.set旧措置区分(旧措置区分1);
        } else {
            RString 旧措置区分2 = taishoshaHaakuMainDiv.getParameters().getDdlKyushochishaKubun2().getSelectedValue();
            parameter.set旧措置区分(旧措置区分2);
        }
        boolean 市町村民税非課税世帯 = taishoshaHaakuMainDiv.getParameters().getChkIsHikazeiSetai().getSelectedValues().contains(new RString("市町村民税非課税世帯"));
        boolean 市町村民税本人非課税者 = taishoshaHaakuMainDiv.getParameters().getChkIsHikazei().getSelectedValues().contains(new RString("市町村民税本人非課税者"));
        boolean 老齢福祉年金受給者 = taishoshaHaakuMainDiv.getParameters().getChkIsRoreiJukyusha().getSelectedValues().contains(new RString("老齢福祉年金受給者"));
        boolean 生活保護受給者 = taishoshaHaakuMainDiv.getParameters().getChkIsSeihoJukyusha().getSelectedValues().contains(new RString("生活保護受給者"));
        RString 施設入所区分 = taishoshaHaakuMainDiv.getParameters().getDdlKyushochishaKubun1().getSelectedValue();
        RString 利用者負担段階 = RiyoshaFutanDankaiHanni.valueOf(taishoshaHaakuMainDiv.getParameters().getDdlRiyoshaFutanDankai().getSelectedValue().toString()).getコード();
        FlexibleDate 基準日 = taishoshaHaakuMainDiv.getParameters().getTxtKijunYMD().getValue();
        FlexibleYear 所得年度 = taishoshaHaakuMainDiv.getParameters().getTxtShotokuNendo().getDomain();

        parameter.set利用者負担段階(利用者負担段階);
        parameter.set基準日(基準日);
        parameter.set市町村民税本人非課税者(市町村民税本人非課税者);
        parameter.set市町村民税非課税世帯(市町村民税非課税世帯);
        parameter.set所得年度(所得年度);
        parameter.set新規更新区分(新規更新区分);
        parameter.set施設入所区分(施設入所区分);
        parameter.set減免減額種類(減免減額種類);
        parameter.set生活保護受給者(生活保護受給者);

        parameter.set老齢福祉年金受給者(老齢福祉年金受給者);
        parameter.set課税世帯の被保険者を含む(課税世帯の被保険者を含む);

        return parameter;
    }

    private void setDataSource(List<KeyValueDataSource> dataSource,
            RString keyNum, RString keyValues) {
        KeyValueDataSource data = new KeyValueDataSource(keyNum, keyValues);
        dataSource.add(data);
    }
}
