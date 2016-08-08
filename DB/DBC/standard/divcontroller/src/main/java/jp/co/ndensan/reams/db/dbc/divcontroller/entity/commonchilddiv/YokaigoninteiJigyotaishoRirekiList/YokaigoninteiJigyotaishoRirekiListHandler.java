/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.YokaigoninteiJigyotaishoRirekiList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.ninteirirekiichiran.JyukyuuSyaDaiTyouResult;
import jp.co.ndensan.reams.db.dbc.business.core.ninteirirekiichiran.SogoJigyouTaisyouSyaJyohoResult;
import jp.co.ndensan.reams.db.dbc.service.core.ninteirirekiichiran.NinteiRirekiIchiran;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyusochisha.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * DBCKD00001_認定履歴一覧
 *
 * @reamsid_L DBC-4350-010 wangxingpeng
 */
public class YokaigoninteiJigyotaishoRirekiListHandler {

    private final YokaigoninteiJigyotaishoRirekiListDiv div;

    /**
     * コンストラクタです。
     *
     * @param div YokaigoninteiJigyotaishoRirekiListDiv
     */
    public YokaigoninteiJigyotaishoRirekiListHandler(YokaigoninteiJigyotaishoRirekiListDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     */
    public void initialize() {
        NinteiRirekiIchiran ninteiRirekiIchiran = NinteiRirekiIchiran.createInstance();
        RString hihokenshaNo = DataPassingConverter.deserialize(div.getHihokenshaNo(), RString.class);
        HihokenshaNo 被保険者番号 = new HihokenshaNo(hihokenshaNo);
        List<JyukyuuSyaDaiTyouResult> 受給者台帳情報 = ninteiRirekiIchiran.getJyukyuuSyaDaiTyouJyoho(被保険者番号);
        List<dgNinteiRirekiList_Row> 受給者認定 = new ArrayList<>();
        for (int i = 0; i < 受給者台帳情報.size(); i++) {
            dgNinteiRirekiList_Row dgNinteiRirekiList = new dgNinteiRirekiList_Row();
            FlexibleDate 申請日 = 受給者台帳情報.get(i).get申請日();
            RString 介護認定状態区分 = 受給者台帳情報.get(i).get要介護認定状態区分().getColumnValue();
            FlexibleDate 有効開始日 = 受給者台帳情報.get(i).get認定有効開始日();
            FlexibleDate 有効終了日 = 受給者台帳情報.get(i).get認定有効終了日();
            RString 申請種別 = 受給者台帳情報.get(i).get申請種別();
            RString みなし区分 = 受給者台帳情報.get(i).getみなし区分();
            boolean 旧措置者フラグ = 受給者台帳情報.get(i).is旧措置者フラグ();
            dgNinteiRirekiList.getShinseiYMD().setValue(申請日);
            dgNinteiRirekiList.setYokaigoJotaiKubun(get状態区分(有効開始日, 介護認定状態区分));
            dgNinteiRirekiList.getNinteiYukoKaishiYMD().setValue(有効開始日);
            dgNinteiRirekiList.getNinteiYukoShuryoYMD().setValue(有効終了日);
            dgNinteiRirekiList.setShiseiShubetsu(JukyuShinseiJiyu.toValue(申請種別).get名称());
            dgNinteiRirekiList.setMinashiKubun(MinashiCode.toValue(みなし区分).get名称());
            dgNinteiRirekiList.setKyusotuSya(KyusochishaKubun.toValue(旧措置者フラグ).get名称());
            受給者認定.add(dgNinteiRirekiList);
        }
        div.getDgNinteiRirekiList().setDataSource(受給者認定);
        List<SogoJigyouTaisyouSyaJyohoResult> 総合事業対象者情報 = ninteiRirekiIchiran.getSogoJigyouTaisyouSyaJyoho(被保険者番号);
        List<dgJigyoTaishoshaList_Row> 総合事業対象者 = new ArrayList<>();
        for (int i = 0; i < 総合事業対象者情報.size(); i++) {
            dgJigyoTaishoshaList_Row dgJigyoTaishoshaList = new dgJigyoTaishoshaList_Row();
            FlexibleDate 適用開始日 = 総合事業対象者情報.get(i).get適用開始日();
            FlexibleDate 適用終了日 = 総合事業対象者情報.get(i).get適用終了日();
            FlexibleDate 決定日 = 総合事業対象者情報.get(i).get決定日();
            FlexibleDate 実施日 = 総合事業対象者情報.get(i).getチェックリスト実施日();
            dgJigyoTaishoshaList.getTekiyoKaishiYMD().setValue(適用開始日);
            dgJigyoTaishoshaList.getTekiyoShuryoYMD().setValue(適用終了日);
            dgJigyoTaishoshaList.getKetteiYMD().setValue(決定日);
            dgJigyoTaishoshaList.getChecklistJisshiYMD().setValue(実施日);
            総合事業対象者.add(dgJigyoTaishoshaList);
        }
        div.getDgJigyoTaishoshaList().setDataSource(総合事業対象者);
    }

    /**
     *
     * @param 有効開始日 FlexibleDate
     * @param 介護認定状態区分 介護認定状態区分
     * @return YokaigoJotaiKubun RString
     */
    public RString get状態区分(FlexibleDate 有効開始日, RString 介護認定状態区分) {
        FlexibleDate 有効開始090401 = new FlexibleDate("20090401");
        FlexibleDate 有効開始060401 = new FlexibleDate("20060401");
        FlexibleDate 有効開始020401 = new FlexibleDate("20020401");
        FlexibleDate 有効開始000401 = new FlexibleDate("20000401");
        if (!有効開始日.isBefore(有効開始000401) && 有効開始日.isBefore(有効開始020401)) {
            return YokaigoJotaiKubun99.toValue(介護認定状態区分).get名称();
        }
        if (有効開始日.isBefore(有効開始060401)) {
            return YokaigoJotaiKubun02.toValue(介護認定状態区分).get名称();
        }
        if (有効開始日.isBefore(有効開始090401)) {
            return YokaigoJotaiKubun06.toValue(介護認定状態区分).get名称();
        } else {
            return YokaigoJotaiKubun09.toValue(介護認定状態区分).get名称();
        }
    }
}
