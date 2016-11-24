/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JukyuNinteirirekiInfo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbz.business.core.ninteirirekiichiran.NinteiRirekiIchiranBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.kyusochisha.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者台帳情報の取得するクラスです。
 *
 * @reamsid_L DBZ-4550-010 zhangzhiming
 */
public class JukyuNinteirirekiInfoHandler {

    private final JukyuNinteirirekiInfoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 受給者台帳情報の共有子のエンティティ
     */
    public JukyuNinteirirekiInfoHandler(JukyuNinteirirekiInfoDiv div) {
        this.div = div;
    }

    /**
     * 初期化処理です。
     *
     * @param ninteiChosaList 受給者台帳情報
     */
    public void initialize(List<NinteiRirekiIchiranBusiness> ninteiChosaList) {
        set受給者台帳情報(ninteiChosaList);
    }

    private void set受給者台帳情報(List<NinteiRirekiIchiranBusiness> ninteiChosaList) {
        List<dgNinteiRireki_Row> rireki_Row = new ArrayList<>();
        for (NinteiRirekiIchiranBusiness list : ninteiChosaList) {
            dgNinteiRireki_Row row = new dgNinteiRireki_Row();
            row.getShinseiYMD().setValue(list.get申請日());
            row.setShiseiShubetsu(new RString(JukyuShinseiJiyu.toValue(list.get申請種別().getKey()).name()));
            FlexibleYearMonth yokaigoJotai = null;

            if (list.get認定有効開始日() != null && !FlexibleDate.EMPTY.equals(list.get認定有効開始日())) {
                yokaigoJotai = list.get認定有効開始日().getYearMonth();
            }
            if (yokaigoJotai == null) {
                row.setYokaigoJotaiKubun(RString.EMPTY);
            } else if (new FlexibleYearMonth("200004").isBeforeOrEquals(yokaigoJotai)
                    && yokaigoJotai.isBeforeOrEquals(new FlexibleYearMonth("200203"))) {
                row.setYokaigoJotaiKubun(YokaigoJotaiKubun99.toValue(list.get要介護認定状態区分().getKey()).get名称());
            } else if (new FlexibleYearMonth("200204").isBeforeOrEquals(yokaigoJotai)
                    && yokaigoJotai.isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
                row.setYokaigoJotaiKubun(YokaigoJotaiKubun02.toValue(list.get要介護認定状態区分().getKey()).get名称());
            } else if (new FlexibleYearMonth("200604").isBeforeOrEquals(yokaigoJotai)
                    && yokaigoJotai.isBeforeOrEquals(new FlexibleYearMonth("200903"))) {
                row.setYokaigoJotaiKubun(YokaigoJotaiKubun06.toValue(list.get要介護認定状態区分().getKey()).get名称());
            } else if (new FlexibleYearMonth("200904").isBeforeOrEquals(yokaigoJotai)) {
                row.setYokaigoJotaiKubun(YokaigoJotaiKubun09.toValue(list.get要介護認定状態区分().getKey()).get名称());
            }
            row.getNinteiYukoKaishiYMD().setValue(list.get認定有効開始日());
            row.getNinteiYukoShuryoYMD().setValue(list.get認定有効終了日());
            row.getNinteiYMD().setValue(list.get認定年月日());
            if (list.is旧措置者フラグ()) {
                row.setKyusotuSya(KyusochishaKubun.toValue(list.is旧措置者フラグ()).get名称());
            }
            if (list.get２号特定疾病コード() != null && !RString.isNullOrEmpty(list.get２号特定疾病コード().getKey())) {
                row.setTokuteiShippei(TokuteiShippei.toValue(list.get２号特定疾病コード().getKey()).get名称());
            }

            row.setMinashiKubun(MinashiCode.toValue(list.getみなし区分().getKey()).get名称());
            rireki_Row.add(row);
        }
        div.getDgNinteiRireki().setDataSource(rireki_Row);
    }
}
