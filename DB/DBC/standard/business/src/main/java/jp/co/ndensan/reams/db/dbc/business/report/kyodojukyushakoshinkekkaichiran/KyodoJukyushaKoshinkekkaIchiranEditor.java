/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyodojukyushakoshinkekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.chohyoseigyohanyo.ChohyoSeigyoHanyoKomokuMei;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JukyushaIdoJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuRiyoshafutanDai2dankai;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuSetaiShotokuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuShotokuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoShokanIchijiSashitomeKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TeiseiKubunCode;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportData;
import jp.co.ndensan.reams.db.dbc.entity.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 共同処理用受給者情報一覧表Editorのインターフェースクラスです。
 *
 * @reamsid_L DBC-2780-030 lishengli
 */
public class KyodoJukyushaKoshinkekkaIchiranEditor implements IKyodoJukyushaKoshinkekkaIchiranEditor {

    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INT_32 = 32;
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString SAKUSEI = new RString("作成");
    private final KyodoJukyushaKoshinkekkaIchiranReportData 帳票用データ;
    private final RString 帳票制御汎用項目名;
    private final RDateTime 作成日時;
    private final IOutputOrder 出力順情報;

    /**
     * コンストラクタです
     *
     * @param 帳票用データ KyodoJukyushaKoshinkekkaIchiranReportData
     * @param 帳票制御汎用項目名 帳票制御汎用項目名
     * @param 作成日時 作成日時
     * @param 出力順情報 IOutputOrder
     */
    public KyodoJukyushaKoshinkekkaIchiranEditor(KyodoJukyushaKoshinkekkaIchiranReportData 帳票用データ,
            RString 帳票制御汎用項目名,
            RDateTime 作成日時,
            IOutputOrder 出力順情報) {
        this.帳票用データ = 帳票用データ;
        this.帳票制御汎用項目名 = 帳票制御汎用項目名;
        this.作成日時 = 作成日時;
        this.出力順情報 = 出力順情報;
    }

    @Override
    public KyodoJukyushaKoshinkekkaIchiranReportSource edit(KyodoJukyushaKoshinkekkaIchiranReportSource source) {
        List<ISetSortItem> 設定項目リスト = 出力順情報.get設定項目リスト();
        source.printTimeStamp = get作成日時();
        source.title = 帳票用データ.get帳票タイトル();
        source.hokenshaNo = 帳票用データ.get共同処理一時TBL().get保険者番号();
        source.hokenshaName = 帳票用データ.get共同処理一時TBL().get保険者名();
        source.shutsuryokujun1 = get並び順(設定項目リスト, INDEX_1);
        source.shutsuryokujun2 = get並び順(設定項目リスト, INDEX_2);
        source.shutsuryokujun3 = get並び順(設定項目リスト, INDEX_3);
        source.shutsuryokujun4 = get並び順(設定項目リスト, INDEX_4);
        source.shutsuryokujun5 = get並び順(設定項目リスト, INDEX_5);
        source.kaipage1 = get改頁(設定項目リスト, INDEX_1);
        source.kaipage2 = get改頁(設定項目リスト, INDEX_2);
        source.kaipage3 = get改頁(設定項目リスト, INDEX_3);
        source.kaipage4 = get改頁(設定項目リスト, INDEX_4);
        source.kaipage5 = get改頁(設定項目リスト, INDEX_5);
        if (ChohyoSeigyoHanyoKomokuMei.帳票タイトル_定期.get名称().equals(帳票制御汎用項目名)) {
            source.komokuName1 = new RString("訂正区分");
            source.komokuName2 = new RString("訂正区分");
            source.komokuName3 = new RString("訂正区分");
        }
        source.list1_1 = RString.EMPTY;
        source.list1_2 = new RString("基本情報");
        source.list1_3 = 帳票用データ.get被保険者一時TBL().get登録被保険者番号();
        source.list1_9 = 帳票用データ.get被保険者一時TBL().get行政区コード();
        source.list1_10 = 帳票用データ.get被保険者一時TBL().get行政区名();
        source.list2_2 = 帳票用データ.get被保険者一時TBL().get宛名カナ名称();
        source.list2_4 = 帳票用データ.get被保険者一時TBL().get町域コード();
        source.list3_1 = 帳票用データ.get被保険者一時TBL().get宛名名称();
        source.list4_1 = RString.EMPTY;
        source.list4_2 = new RString("償還払給付情報");
        source.list5_1 = RString.EMPTY;
        source.list5_2 = new RString("高額介護支給情報");
        if (!RString.isNullOrEmpty(帳票用データ.get共同処理一時TBL().get基_交換情報識別番号())) {
            source.list1_4 = getパターン4(帳票用データ.get共同処理一時TBL().get基_異動年月日());
            source.list1_5 = getコードと名称(帳票用データ.get共同処理一時TBL().get基_異動区分コード(),
                    JukyushaIF_IdoKubunCode.toValue(帳票用データ.get共同処理一時TBL().get基_異動区分コード()).get名称());
            source.list1_6 = getコードと名称(帳票用データ.get共同処理一時TBL().get基_異動事由(),
                    JukyushaIF_JukyushaIdoJiyu.toValue(帳票用データ.get共同処理一時TBL().get基_異動事由()).get名称());
            source.list1_7 = getパターン4(帳票用データ.get共同処理一時TBL().get基_訂正年月日());
            source.list1_8 = getコードと名称(帳票用データ.get共同処理一時TBL().get基_訂正区分コード(),
                    JukyushaIF_TeiseiKubunCode.toValue(帳票用データ.get共同処理一時TBL().get基_訂正区分コード()).get名称());
            source.list1_11 = 帳票用データ.get共同処理一時TBL().get基_帳票出力順序コード();
            source.list2_1 = 帳票用データ.get共同処理一時TBL().get基_証記載保険者番号();
            source.list2_3 = 帳票用データ.get共同処理一時TBL().get基_郵便番号();
            source.list2_5 = 帳票用データ.get共同処理一時TBL().get基_住所カナ();
            source.list3_2 = 帳票用データ.get共同処理一時TBL().get基_電話番号();
            source.list3_3 = 帳票用データ.get共同処理一時TBL().get基_住所();
            if (!RString.isNullOrEmpty(帳票用データ.get共同処理一時TBL().get償_交換情報識別番号())) {
                source.list4_3 = getパターン4(帳票用データ.get共同処理一時TBL().get償_異動年月日());
                source.list4_4 = getコードと名称(帳票用データ.get共同処理一時TBL().get償_異動区分コード(),
                        JukyushaIF_IdoKubunCode.toValue(帳票用データ.get共同処理一時TBL().get償_異動区分コード()).get名称());
                source.list4_5 = getコードと名称(帳票用データ.get共同処理一時TBL().get償_異動事由(),
                        JukyushaIF_JukyushaIdoJiyu.toValue(帳票用データ.get共同処理一時TBL().get償_異動事由()).get名称());
                source.list4_6 = getパターン4(帳票用データ.get共同処理一時TBL().get償_訂正年月日());
                source.list4_7 = getコードと名称(帳票用データ.get共同処理一時TBL().get償_訂正区分コード(),
                        JukyushaIF_TeiseiKubunCode.toValue(帳票用データ.get共同処理一時TBL().get償_訂正区分コード()).get名称());
                source.list4_8 = getパターン4(帳票用データ.get共同処理一時TBL().get償_保険給付支払の一時差止の開始年月日());
                source.list4_9 = getパターン4(帳票用データ.get共同処理一時TBL().get償_保険給付支払の一時差止の終了年月日());
                source.list4_10 = getコードと名称(帳票用データ.get共同処理一時TBL().get償_保険給付支払の一時差止区分(),
                        JukyushaIF_KyodoShokanIchijiSashitomeKubunCode.toValue(
                                帳票用データ.get共同処理一時TBL().get償_保険給付支払の一時差止区分()).get名称());
                source.list4_11 = get一時差止金額(帳票用データ.get共同処理一時TBL().get償_保険給付支払の一時差止金額());
            }
            if (!RString.isNullOrEmpty(帳票用データ.get共同処理一時TBL().get高_交換情報識別番号())) {
                source.list5_3 = getパターン4(帳票用データ.get共同処理一時TBL().get高_異動年月日());
                source.list5_4 = getコードと名称(帳票用データ.get共同処理一時TBL().get高_異動区分コード(),
                        JukyushaIF_IdoKubunCode.toValue(帳票用データ.get共同処理一時TBL().get高_異動区分コード()).get名称());
                source.list5_5 = getコードと名称(帳票用データ.get共同処理一時TBL().get高_異動事由(),
                        JukyushaIF_JukyushaIdoJiyu.toValue(帳票用データ.get共同処理一時TBL().get高_異動事由()).get名称());
                source.list5_6 = getパターン4(帳票用データ.get共同処理一時TBL().get高_訂正年月日());
                source.list5_7 = getコードと名称(帳票用データ.get共同処理一時TBL().get高_訂正区分コード(),
                        JukyushaIF_TeiseiKubunCode.toValue(帳票用データ.get共同処理一時TBL().get高_訂正区分コード()).get名称());
                source.list5_8 = 帳票用データ.get共同処理一時TBL().get高_世帯主被保険者番号();
                source.list5_9 = getコードと名称(帳票用データ.get共同処理一時TBL().get高_世帯所得区分コード(),
                        JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.toValue(帳票用データ.get共同処理一時TBL().get高_世帯所得区分コード()).get名称());
                source.list5_10 = getコードと名称(帳票用データ.get共同処理一時TBL().get高_所得区分コード(),
                        JukyushaIF_KyodoKogakuShotokuKubunCode.toValue(帳票用データ.get共同処理一時TBL().get高_所得区分コード()).get名称());
                source.list5_11 = 帳票用データ.get共同処理一時TBL().get高_利用者負担第２段階();
                source.list5_12 = 帳票用データ.get共同処理一時TBL().get高_支給申請書出力の有無();
                source.list6_1 = 帳票用データ.get共同処理一時TBL().get高_老齢福祉年金受給の有無();
            }
            source.list7_1 = get住所1(帳票用データ.get共同処理一時TBL().get基_住所());
            source.list8_1 = get住所2(帳票用データ.get共同処理一時TBL().get基_住所());
        } else {
            source = set共同処理用受給者異動基本送付(source);
        }
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(帳票用データ.get被保険者一時TBL().get被保険者番号())) {
            source.shinseishoKanriNo = new ExpandedInformation(new Code("0003"),
                    new RString("被保険者番号"), 帳票用データ.get被保険者一時TBL().get被保険者番号());
        }
        return source;
    }

    private KyodoJukyushaKoshinkekkaIchiranReportSource set共同処理用受給者異動基本送付(KyodoJukyushaKoshinkekkaIchiranReportSource source) {
        source.list1_4 = getパターン4(帳票用データ.get共同処理用受給者異動基本送付TBL().getIdoYMD());
        source.list1_5 = getコードと名称(帳票用データ.get共同処理用受給者異動基本送付TBL().getIdoKubunCode(),
                JukyushaIF_IdoKubunCode.toValue(帳票用データ.get共同処理用受給者異動基本送付TBL().getIdoKubunCode()).get名称());
        source.list1_6 = getコードと名称(帳票用データ.get共同処理用受給者異動基本送付TBL().getJukyushaIdoJiyu(),
                JukyushaIF_JukyushaIdoJiyu.toValue(帳票用データ.get共同処理用受給者異動基本送付TBL().getJukyushaIdoJiyu()).get名称());
        source.list1_7 = getパターン4(帳票用データ.get共同処理用受給者異動基本送付TBL().getTeiseiYMD());
        source.list1_8 = getコードと名称(帳票用データ.get共同処理用受給者異動基本送付TBL().getTeiseiKubunCode(),
                JukyushaIF_TeiseiKubunCode.toValue(帳票用データ.get共同処理用受給者異動基本送付TBL().getTeiseiKubunCode()).get名称());
        source.list1_11 = 帳票用データ.get共同処理用受給者異動基本送付TBL().getChohyoOutputJunjyoCode();
        source.list2_1 = get証記載保険者番号(帳票用データ.get共同処理用受給者異動基本送付TBL().getShoKisaiHokenshaNo());
        source.list2_3 = get郵便番号(帳票用データ.get共同処理用受給者異動基本送付TBL().getYubinNo());
        source.list2_5 = 帳票用データ.get共同処理用受給者異動基本送付TBL().getDdressKana();
        source.list3_2 = get電話番号(帳票用データ.get共同処理用受給者異動基本送付TBL().getTelNo());
        source.list3_3 = get住所(帳票用データ.get共同処理用受給者異動基本送付TBL().getAddress());
        if (!RString.isNullOrEmpty(帳票用データ.get共同処理一時TBL().get償_交換情報識別番号())) {
            source.list4_3 = getパターン4(帳票用データ.get共同処理用受給者異動償還送付TBL().getIdoYMD());
            source.list4_4 = getコードと名称(帳票用データ.get共同処理用受給者異動償還送付TBL().getIdoKubunCode(),
                    JukyushaIF_IdoKubunCode.toValue(帳票用データ.get共同処理用受給者異動償還送付TBL().getIdoKubunCode()).get名称());
            source.list4_5 = getコードと名称(帳票用データ.get共同処理用受給者異動償還送付TBL().getJukyushaIdoJiyu(),
                    JukyushaIF_JukyushaIdoJiyu.toValue(帳票用データ.get共同処理用受給者異動償還送付TBL().getJukyushaIdoJiyu()).get名称());
            source.list4_6 = getパターン4(帳票用データ.get共同処理用受給者異動償還送付TBL().getTeiseiYMD());
            source.list4_7 = getコードと名称(帳票用データ.get共同処理用受給者異動償還送付TBL().getTeiseiKubunCode(),
                    JukyushaIF_TeiseiKubunCode.toValue(帳票用データ.get共同処理用受給者異動償還送付TBL().getTeiseiKubunCode()).get名称());
            source.list4_8 = getパターン4(帳票用データ.get共同処理用受給者異動償還送付TBL().getHokenKyufuIchijiSashitomeKaishiYMD());
            source.list4_9 = getパターン4(帳票用データ.get共同処理用受給者異動償還送付TBL().getHokenKyufuIchijiSashitomeShuryoYMD());
            source.list4_10 = getコードと名称(帳票用データ.get共同処理用受給者異動償還送付TBL().getHokenkyufuIchijiSashitomeKubunCode(),
                    JukyushaIF_KyodoShokanIchijiSashitomeKubunCode.toValue(帳票用データ.get共同処理用受給者異動償還送付TBL()
                            .getHokenkyufuIchijiSashitomeKubunCode()).get名称());
            source.list4_11 = DecimalFormatter.toRString(
                    帳票用データ.get共同処理用受給者異動償還送付TBL().getHokenkyufuIchijiSashitomeKingaku(), 0);
        }
        if (!RString.isNullOrEmpty(帳票用データ.get共同処理一時TBL().get高_交換情報識別番号())) {
            source.list5_3 = getパターン4(帳票用データ.get共同処理用受給者異動高額送付TBL().getIdoYMD());
            source.list5_4 = getコードと名称(帳票用データ.get共同処理用受給者異動高額送付TBL().getIdoKubunCode(),
                    JukyushaIF_IdoKubunCode.toValue(帳票用データ.get共同処理用受給者異動高額送付TBL().getIdoKubunCode()).get名称());
            source.list5_5 = getコードと名称(帳票用データ.get共同処理用受給者異動高額送付TBL().getJukyushaIdoJiyu(),
                    JukyushaIF_JukyushaIdoJiyu.toValue(帳票用データ.get共同処理用受給者異動高額送付TBL().getJukyushaIdoJiyu()).get名称());
            source.list5_6 = getパターン4(帳票用データ.get共同処理用受給者異動高額送付TBL().getTeiseiYMD());
            source.list5_7 = getコードと名称(帳票用データ.get共同処理用受給者異動高額送付TBL().getTeiseiKubunCode(),
                    JukyushaIF_TeiseiKubunCode.toValue(帳票用データ.get共同処理用受給者異動高額送付TBL().getTeiseiKubunCode()).get名称());
            source.list5_8 = get世帯主被保険者番号(帳票用データ.get共同処理用受給者異動高額送付TBL().getSetaiShuyakuNo());
            source.list5_9 = getコードと名称(帳票用データ.get共同処理用受給者異動高額送付TBL().getSetaiShotokuKubunCode(),
                    JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.toValue(
                            帳票用データ.get共同処理用受給者異動高額送付TBL().getSetaiShotokuKubunCode()).get名称());
            source.list5_10 = getコードと名称(帳票用データ.get共同処理用受給者異動高額送付TBL().getShotokuKubunCode(),
                    JukyushaIF_KyodoKogakuShotokuKubunCode.toValue(
                            帳票用データ.get共同処理用受給者異動高額送付TBL().getShotokuKubunCode()).get名称());
            if (帳票用データ.get共同処理用受給者異動高額送付TBL().getRiyoshaFutan2DankaiAriFlag()) {
                source.list5_11 = getコードと名称(JukyushaIF_KyodoKogakuRiyoshafutanDai2dankai.該当有り.getコード(),
                        JukyushaIF_KyodoKogakuRiyoshafutanDai2dankai.該当有り.get名称());
            } else {
                source.list5_11 = getコードと名称(JukyushaIF_KyodoKogakuRiyoshafutanDai2dankai.該当無し.getコード(),
                        JukyushaIF_KyodoKogakuRiyoshafutanDai2dankai.該当無し.get名称());
            }
            if (帳票用データ.get共同処理用受給者異動高額送付TBL().getShikyuShinseishoOutputAriFlag()) {
                source.list5_12 = getコードと名称(JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu.出力有り.getコード(),
                        JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu.出力有り.get名称());
            } else {
                source.list5_12 = getコードと名称(JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu.出力無し.getコード(),
                        JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu.出力無し.get名称());
            }
            if (帳票用データ.get共同処理用受給者異動高額送付TBL().getRoureiFukushiNenkinJukyuAriFlag()) {
                source.list6_1 = getコードと名称(JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu.受給有り.getコード(),
                        JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu.受給有り.get名称());
            } else {
                source.list6_1 = getコードと名称(JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu.受給無し.getコード(),
                        JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu.受給無し.get名称());
            }
        }
        source.list7_1 = get住所1(帳票用データ.get共同処理用受給者異動基本送付TBL().getAddress());
        source.list8_1 = get住所2(帳票用データ.get共同処理用受給者異動基本送付TBL().getAddress());
        return source;
    }

    private RString get作成日時() {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        RDateTime printdate = 作成日時;
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(SAKUSEI);
        return printTimeStampSb.toRString();
    }

    private RString get並び順(List<ISetSortItem> 設定項目リスト, int index) {
        if (index < 設定項目リスト.size()) {
            return 設定項目リスト.get(index).get項目名();
        }
        return RString.EMPTY;
    }

    private RString get改頁(List<ISetSortItem> 設定項目リスト, int index) {
        if (index < 設定項目リスト.size() && 設定項目リスト.get(index).is改頁項目()) {
            return 設定項目リスト.get(index).get項目名();
        }
        return RString.EMPTY;
    }

    private RString getパターン4(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString getコードと名称(RString コード, RString 名称) {
        if (!RString.isNullOrEmpty(コード)) {
            return コード.concat(名称);
        }
        return RString.EMPTY;
    }

    private RString get住所(RString 住所) {
        if (!RString.isNullOrEmpty(住所) && 住所.length() <= INT_32) {
            return 住所;
        }
        return RString.EMPTY;
    }

    private RString get住所1(RString 住所) {
        if (RString.isNullOrEmpty(住所) || 住所.length() <= INT_32) {
            return RString.EMPTY;
        }
        return 住所.substring(0, INT_32);
    }

    private RString get住所2(RString 住所) {
        if (RString.isNullOrEmpty(住所) || 住所.length() <= INT_32) {
            return RString.EMPTY;
        }
        return 住所.substring(INT_32);
    }

    private RString get証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        if (証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
            return 証記載保険者番号.value();
        }
        return RString.EMPTY;
    }

    private RString get郵便番号(YubinNo 郵便番号) {
        if (郵便番号 != null && !郵便番号.isEmpty()) {
            return 郵便番号.getEditedYubinNo();
        }
        return RString.EMPTY;
    }

    private RString get電話番号(TelNo 電話番号) {
        if (電話番号 != null && !電話番号.isEmpty()) {
            return 電話番号.value();
        }
        return RString.EMPTY;
    }

    private RString get世帯主被保険者番号(HihokenshaNo 世帯主被保険者番号) {
        if (世帯主被保険者番号 != null && !世帯主被保険者番号.isEmpty()) {
            return 世帯主被保険者番号.value();
        }
        return RString.EMPTY;
    }

    private RString get一時差止金額(RString 金額) {
        if (!RString.isNullOrEmpty(金額)) {
            return DecimalFormatter.toRString(new Decimal(金額.toString()), 0);
        }
        return RString.EMPTY;
    }
}
