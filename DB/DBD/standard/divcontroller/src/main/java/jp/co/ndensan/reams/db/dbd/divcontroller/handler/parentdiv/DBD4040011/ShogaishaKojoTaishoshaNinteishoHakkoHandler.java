/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4040011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shogaishakoujo.ShogaishaKoujo;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo.NinteiNaiyoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo.Ninteikubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4040011.ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv;
import jp.co.ndensan.reams.db.dbd.service.core.basic.shogaishakoujo.ShogaishaKoujoService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 障がい者控除対象者認定ハンドラクラスです
 *
 * @reamsid_L DBD-3870-010 jinge
 */
public class ShogaishaKojoTaishoshaNinteishoHakkoHandler {

    private final ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div;
    private static final Code CODE_0003 = new Code("0003");
    private static final RString NAME_被保険者番号 = new RString("被保険者番号");

    /**
     * コンストラクタです。
     *
     * @param div ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv
     */
    public ShogaishaKojoTaishoshaNinteishoHakkoHandler(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void initialize(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        RDate 発行日 = RDate.getNowDate();
        div.getShogaishaKojoNinteishoHakko().getShogaishaKojoNinteisho().getNinteishoPrintSetting().initialize(true, 発行日, false, false, null, false);
        div.getTaishoshaAtena().initialize(識別コード);
        div.getTaishoshaKaigoShikaku().initialize(被保険者番号);
        ShogaishaKoujoService shogaishaKoujoService = ShogaishaKoujoService.createInstance();
        ShogaishaKoujo shogaishaKoujo = shogaishaKoujoService.getDbT4038ShogaishaKoujoEntity(被保険者番号);
        if (shogaishaKoujo != null) {
            if (shogaishaKoujo.get認定区分() != null && !shogaishaKoujo.get認定区分().isEmpty()) {
                div.getShogaishaKojoNinteishoHakko().getShogaishaKojoTaishoshaDetail().getTxtNinteiKubun().setValue(Ninteikubun.toValue(shogaishaKoujo.get認定区分()).get名称());
            }
            if (shogaishaKoujo.get認定内容() != null && !shogaishaKoujo.get認定内容().isEmpty()) {
                div.getShogaishaKojoNinteishoHakko().getShogaishaKojoTaishoshaDetail().getTxtNinteiNaiyo().setValue(NinteiNaiyoKubun.toValue(shogaishaKoujo.get認定内容()).get名称());
            }
            if (shogaishaKoujo.get認知症高齢者自立度() != null && !shogaishaKoujo.get認知症高齢者自立度().isEmpty()) {
                div.getShogaishaKojoNinteishoHakko().getShogaishaKojoTaishoshaDetail().getTxtNinnchishouJiritsudo().
                        setValue(NinchishoNichijoSeikatsuJiritsudoCode.toValue(shogaishaKoujo.get認知症高齢者自立度().getColumnValue()).get名称());
            }
            if (shogaishaKoujo.get障害高齢者自立度() != null && !shogaishaKoujo.get障害高齢者自立度().isEmpty()) {
                div.getShogaishaKojoNinteishoHakko().getShogaishaKojoTaishoshaDetail().getTxtShougaishaJiritsudo().setValue(
                        ShogaiNichijoSeikatsuJiritsudoCode.toValue(shogaishaKoujo.get障害高齢者自立度().getColumnValue()).get名称());
            }
            if (shogaishaKoujo.get障がい者手帳あり()) {
                List checkedItemList = new ArrayList<>();
                checkedItemList.add(new RString("key0"));
                div.getShogaishaKojoNinteishoHakko().getChkTechoAri().setSelectedItemsByKey(checkedItemList);
            }

        } else {

            div.getShogaishaKojoNinteishoHakko().getShogaishaKojoTaishoshaDetail().getTxtNinteiNaiyo().clearValue();
            div.getShogaishaKojoNinteishoHakko().getShogaishaKojoTaishoshaDetail().getTxtNinteiKubun().clearValue();

        }
        PersonalData personalData = PersonalData.of(識別コード, new ExpandedInformation(CODE_0003, NAME_被保険者番号, 被保険者番号.getColumnValue()));
        AccessLogger.log(AccessLogType.照会, personalData);
    }
}
