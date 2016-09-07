/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1090002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.ShinseiRiyuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.homonkaigogemmen.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002.GemmenGengakuShoHakkoMainDiv;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengakushohakkomain.IGemmenGengakuShoHakkoMainMapperFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免減額認定証・決定通知書個別発行のハンドラークラスです。
 *
 * @reamsid_L DBD-3540-010 xuyue
 */
public class GemmenGengakuShoHakkoMainHandler {

    private static final RString 該当 = new RString("該当");
    private static final RString 非該当 = new RString("非該当");
    private static final RString 対象者以外 = new RString("対象者以外");
    private static final RString 対象者 = new RString("対象者");

    private final GemmenGengakuShoHakkoMainDiv div;
    private final IGemmenGengakuShoHakkoMainMapperFinder finder;

    /**
     * コンストラクタです。
     *
     * @param div 受給照会のコントロールdiv
     */
    public GemmenGengakuShoHakkoMainHandler(GemmenGengakuShoHakkoMainDiv div) {
        this.div = div;
        this.finder = IGemmenGengakuShoHakkoMainMapperFinder.createIntance();
    }

    /**
     * 利用者負担額減免の情報が存在するかを判断します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 結果 true:利用者負担額減免の情報が存在
     */
    public boolean is利用者負担額減免の情報存在(HihokenshaNo 被保険者番号) {
        return finder.is利用者負担額減免の情報存在(被保険者番号);
    }

    /**
     * 負担限度額認定の情報が存在するかを判断します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 結果 true:負担限度額認定の情報が存在
     */
    public boolean is負担限度額認定の情報存在(HihokenshaNo 被保険者番号) {
        return finder.is負担限度額認定の情報存在(被保険者番号);
    }

    /**
     * 社会福祉法人等利用者負担軽減の情報が存在するかを判断します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 結果 true:社会福祉法人等利用者負担軽減の情報が存在
     */
    public boolean is社会福祉法人等利用者負担軽減の情報存在(HihokenshaNo 被保険者番号) {
        return finder.is社会福祉法人等利用者負担軽減の情報存在(被保険者番号);
    }

    /**
     * 訪問介護利用者負担額減額の情報が存在するかを判断します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 結果 true:訪問介護利用者負担額減額の情報が存在
     */
    public boolean is訪問介護利用者負担額減額の情報存在(HihokenshaNo 被保険者番号) {
        return finder.is訪問介護利用者負担額減額の情報存在(被保険者番号);
    }

    /**
     * 特別地域加算減免の情報が存在するかを判断します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 結果 true:特別地域加算減免の情報が存在
     */
    public boolean is特別地域加算減免の情報存在(HihokenshaNo 被保険者番号) {
        return finder.is特別地域加算減免の情報存在(被保険者番号);
    }

    /**
     * 利用者負担額減免の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 利用者負担額減免の情報
     */
    public ArrayList<RiyoshaFutangakuGengaku> get利用者負担額減免の情報(HihokenshaNo 被保険者番号) {
        return finder.get利用者負担額減免の情報(被保険者番号);
    }

    /**
     * 負担限度額認定の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 負担限度額認定の情報
     */
    public ArrayList<FutanGendogakuNintei> get負担限度額認定の情報(HihokenshaNo 被保険者番号) {
        return finder.get負担限度額認定の情報(被保険者番号);
    }

    /**
     * 社会福祉法人等利用者負担軽減の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 社会福祉法人等利用者負担軽減の情報
     */
    public ArrayList<ShakaifukuRiyoshaFutanKeigen> get社会福祉法人等利用者負担軽減の情報(HihokenshaNo 被保険者番号) {
        return finder.get社会福祉法人等利用者負担軽減の情報(被保険者番号);
    }

    /**
     * 訪問介護利用者負担額減額の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 訪問介護利用者負担額減額の情報
     */
    public ArrayList<HomonKaigoRiyoshaFutangakuGengaku> get訪問介護利用者負担額減額の情報(HihokenshaNo 被保険者番号) {
        return finder.get訪問介護利用者負担額減額の情報(被保険者番号);
    }

    /**
     * 特別地域加算減免の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 特別地域加算減免の情報
     */
    public ArrayList<TokubetsuchiikiKasanGemmen> get特別地域加算減免の情報(HihokenshaNo 被保険者番号) {
        return finder.get特別地域加算減免の情報(被保険者番号);
    }

    /**
     * 利用者負担額減額を選択する場合、利用者負担額減額エリアを設定します。
     *
     * @param list 利用者負担額減額list
     * @param 被保険者番号 被保険者番号
     */
    public void 利用者負担額減額を選択する場合の設定(List<RiyoshaFutangakuGengaku> list, HihokenshaNo 被保険者番号) {
        div.getRiyoshaFutangakuGenmen().setDisplayNone(false);
        div.getFutanGendogakuNintei().setDisplayNone(true);
        div.getHomonKaigoRiyoshaFutangakuGengaku().setDisplayNone(true);
        div.getShafukuHojinToRiyushaFutanKeigen().setDisplayNone(true);
        div.getTokubetsuChilkiKasanGenmen().setDisplayNone(true);
        クリア利用者負担額減免エリア();
        div.getBtnOutputMaeRireki().setDisabled(false);
        div.getBtnOutputAtoRireki().setDisabled(false);

        if (list != null && !list.isEmpty()) {
            RiyoshaFutangakuGengaku riyoshaFutangakuGengaku = list.get(list.size() - 1);
            set認定証(riyoshaFutangakuGengaku.get決定区分(), new RString("利用者負担額減額・免除等認定証"));
            set通知書(new RString("利用者負担額減額・免除認定決定通知書"), ReportIdDBD.DBD100009.getReportId());
            set利用者負担額減免エリア(riyoshaFutangakuGengaku);
            div.setRiyoshaFutanGenmenInfoIndex(new RString(Integer.toString(list.size() - 1)));
            div.getBtnOutputAtoRireki().setDisabled(true);
            if (1 == list.size()) {
                div.getBtnOutputMaeRireki().setDisabled(true);
            }
        } else {
            div.setHiddenRirekiNo(new RString("-1"));
            div.setRiyoshaFutanGenmenInfoIndex(new RString("-1"));
            div.getBtnOutputMaeRireki().setDisabled(true);
            div.getBtnOutputAtoRireki().setDisabled(true);
        }
    }

    /**
     * 負担限度額認定を選択する場合、負担限度額認定エリアを設定します。
     *
     * @param list 負担限度額認定list
     * @param 被保険者番号 被保険者番号
     */
    public void 負担限度額認定を選択する場合の設定(List<FutanGendogakuNintei> list, HihokenshaNo 被保険者番号) {
        div.getRiyoshaFutangakuGenmen().setDisplayNone(true);
        div.getFutanGendogakuNintei().setDisplayNone(false);
        div.getHomonKaigoRiyoshaFutangakuGengaku().setDisplayNone(true);
        div.getShafukuHojinToRiyushaFutanKeigen().setDisplayNone(true);
        div.getTokubetsuChilkiKasanGenmen().setDisplayNone(true);
        クリア負担限度額認定エリア();
        div.getBtnOutputMaeRireki().setDisabled(false);
        div.getBtnOutputAtoRireki().setDisabled(false);

        if (list != null && !list.isEmpty()) {
            FutanGendogakuNintei futanGendogakuNintei = list.get(list.size() - 1);
            set認定証(futanGendogakuNintei.get決定区分(), new RString("負担限度額認定証"));
            set通知書(new RString("負担限度額決定通知書"), ReportIdDBD.DBD100013.getReportId());
            set負担限度額認定エリア(futanGendogakuNintei);
            div.setFutanGendogakuNinteiIndex(new RString(Integer.toString(list.size() - 1)));
            div.getBtnOutputAtoRireki().setDisabled(true);
            if (1 == list.size()) {
                div.getBtnOutputMaeRireki().setDisabled(true);
            }
        } else {
            div.setHiddenRirekiNo(new RString("-1"));
            div.setFutanGendogakuNinteiIndex(new RString("-1"));
            div.getBtnOutputMaeRireki().setDisabled(true);
            div.getBtnOutputAtoRireki().setDisabled(true);
        }
    }

    /**
     * 社会福祉法人等利用者負担軽減を選択する場合、社会福祉法人等利用者負担軽減エリアを設定します。
     *
     * @param list 社会福祉法人等利用者負担軽減list
     * @param 被保険者番号 被保険者番号
     */
    public void 社会福祉法人等利用者負担軽減を選択する場合の設定(List<ShakaifukuRiyoshaFutanKeigen> list, HihokenshaNo 被保険者番号) {
        div.getRiyoshaFutangakuGenmen().setDisplayNone(true);
        div.getFutanGendogakuNintei().setDisplayNone(true);
        div.getHomonKaigoRiyoshaFutangakuGengaku().setDisplayNone(true);
        div.getShafukuHojinToRiyushaFutanKeigen().setDisplayNone(false);
        div.getTokubetsuChilkiKasanGenmen().setDisplayNone(true);
        クリア社会福祉法人等利用者負担軽減エリア();
        div.getBtnOutputMaeRireki().setDisabled(false);
        div.getBtnOutputAtoRireki().setDisabled(false);

        if (list != null && !list.isEmpty()) {
            ShakaifukuRiyoshaFutanKeigen shakaifukuRiyoshaFutanKeigen = list.get(list.size() - 1);
            set認定証(shakaifukuRiyoshaFutanKeigen.get決定区分(), new RString("社会福祉法人等利用者負担軽減確認証"));
            set通知書(new RString("社会福祉法人等利用者負担軽減対象決定通知書"), ReportIdDBD.DBD100012.getReportId());
            set社会福祉法人等利用者負担軽減エリア(shakaifukuRiyoshaFutanKeigen);
            div.setShafukuHojinToRiyushaFutanKeigenIndex(new RString(Integer.toString(list.size() - 1)));
            div.getBtnOutputAtoRireki().setDisabled(true);
            if (1 == list.size()) {
                div.getBtnOutputMaeRireki().setDisabled(true);
            }
        } else {
            div.setHiddenRirekiNo(new RString("-1"));
            div.setShafukuHojinToRiyushaFutanKeigenIndex(new RString("-1"));
            div.getBtnOutputMaeRireki().setDisabled(true);
            div.getBtnOutputAtoRireki().setDisabled(true);
        }
    }

    /**
     * 訪問介護利用者負担額減額を選択する場合、訪問介護利用者負担額減額エリアを設定します。
     *
     * @param list 訪問介護利用者負担額減額list
     * @param 被保険者番号 被保険者番号
     */
    public void 訪問介護利用者負担額減額を選択する場合の設定(List<HomonKaigoRiyoshaFutangakuGengaku> list, HihokenshaNo 被保険者番号) {
        div.getRiyoshaFutangakuGenmen().setDisplayNone(true);
        div.getFutanGendogakuNintei().setDisplayNone(true);
        div.getHomonKaigoRiyoshaFutangakuGengaku().setDisplayNone(false);
        div.getShafukuHojinToRiyushaFutanKeigen().setDisplayNone(true);
        div.getTokubetsuChilkiKasanGenmen().setDisplayNone(true);
        クリア訪問介護利用者負担額減額エリア();
        div.getBtnOutputMaeRireki().setDisabled(false);
        div.getBtnOutputAtoRireki().setDisabled(false);

        if (list != null && !list.isEmpty()) {
            HomonKaigoRiyoshaFutangakuGengaku homonKaigoRiyoshaFutangaku = list.get(list.size() - 1);
            set認定証(homonKaigoRiyoshaFutangaku.get決定区分(), new RString("訪問介護等利用者負担額減額認定証"));
            set通知書(new RString("訪問介護等利用者負担額減額決定通知書"), ReportIdDBD.DBD100011.getReportId());
            set訪問介護利用者負担額減額エリア(homonKaigoRiyoshaFutangaku);
            div.setHomonKaigoRiyoshaFutangakuGengakuIndex(new RString(Integer.toString(list.size() - 1)));
            div.getBtnOutputAtoRireki().setDisabled(true);
            if (1 == list.size()) {
                div.getBtnOutputMaeRireki().setDisabled(true);
            }
        } else {
            div.setHiddenRirekiNo(new RString("-1"));
            div.setHomonKaigoRiyoshaFutangakuGengakuIndex(new RString("-1"));
            div.getBtnOutputMaeRireki().setDisabled(true);
            div.getBtnOutputAtoRireki().setDisabled(true);
        }
    }

    /**
     * 特別地域加算減免を選択する場合、特別地域加算減免エリアを設定します。
     *
     * @param list 特別地域加算減免list
     * @param 被保険者番号 被保険者番号
     */
    public void 特別地域加算減免を選択する場合の設定(List<TokubetsuchiikiKasanGemmen> list, HihokenshaNo 被保険者番号) {
        div.getRiyoshaFutangakuGenmen().setDisplayNone(true);
        div.getFutanGendogakuNintei().setDisplayNone(true);
        div.getHomonKaigoRiyoshaFutangakuGengaku().setDisplayNone(true);
        div.getShafukuHojinToRiyushaFutanKeigen().setDisplayNone(true);
        div.getTokubetsuChilkiKasanGenmen().setDisplayNone(false);
        クリア特別地域加算減免エリア();
        div.getBtnOutputMaeRireki().setDisabled(false);
        div.getBtnOutputAtoRireki().setDisabled(false);

        if (list != null && !list.isEmpty()) {
            TokubetsuchiikiKasanGemmen tokubetsuchiikiKasanGemmen = list.get(list.size() - 1);
            set認定証(tokubetsuchiikiKasanGemmen.get決定区分(), new RString("特別地域加算に係る訪問介護利用者負担減額確認証"));
            set通知書(new RString("特別地域加算に係る訪問介護利用者負担減額決定通知書"), ReportIdDBD.DBD100014.getReportId());
            set特別地域加算減免エリア(tokubetsuchiikiKasanGemmen);
            div.setTokubetsuChilkiKasanGenmenIndex(new RString(Integer.toString(list.size() - 1)));
            div.getBtnOutputAtoRireki().setDisabled(true);
            if (1 == list.size()) {
                div.getBtnOutputMaeRireki().setDisabled(true);
            }
        } else {
            div.setHiddenRirekiNo(new RString("-1"));
            div.setTokubetsuChilkiKasanGenmenIndex(new RString("-1"));
            div.getBtnOutputMaeRireki().setDisabled(true);
            div.getBtnOutputAtoRireki().setDisabled(true);
        }
    }

    private void クリア利用者負担額減免エリア() {
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuKetteiKubun().clearValue();
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuKyufuRitsu().clearValue();
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuShinseibi().clearValue();
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuKetteibi().clearValue();
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuTekiyobi().clearValue();
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuYukoKigen().clearValue();
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuShoninShinaiRiyu().clearValue();
    }

    /**
     * 利用者負担額減免エリアの設定処理です。
     *
     * @param riyoshaFutangakuGengaku 利用者負担額減額情報
     */
    public void set利用者負担額減免エリア(RiyoshaFutangakuGengaku riyoshaFutangakuGengaku) {
        div.setHiddenRirekiNo(new RString(riyoshaFutangakuGengaku.get履歴番号()));
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuKetteiKubun().setValue(riyoshaFutangakuGengaku.get決定区分() == null
                || riyoshaFutangakuGengaku.get決定区分().isEmpty()
                        ? RString.EMPTY : KetteiKubun.toValue(riyoshaFutangakuGengaku.get決定区分()).get名称());

        if (riyoshaFutangakuGengaku.get給付率() != null) {
            div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuKyufuRitsu().
                    setValue(new RString(riyoshaFutangakuGengaku.get給付率().getColumnValue().toString()));
        } else {
            div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuKyufuRitsu().clearValue();
        }
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuShinseibi().setValue(riyoshaFutangakuGengaku.get申請年月日());
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuKetteibi().setValue(riyoshaFutangakuGengaku.get決定年月日());
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuTekiyobi().setValue(riyoshaFutangakuGengaku.get適用開始年月日());
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuYukoKigen().setValue(riyoshaFutangakuGengaku.get適用終了年月日());
        div.getRiyoshaFutangakuGenmen().getTxtRiyoshaFutanGendogakuShoninShinaiRiyu().setValue(riyoshaFutangakuGengaku.get非承認理由());
    }

    private void クリア負担限度額認定エリア() {
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiKetteiKubun().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiShinseibi().clearValue();
        div.getFutanGendogakuNintei().getFutanGendogakuNinteiKetteibi().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiTekiyobi().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiYukoKigen().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiShoninShinsaiRiyu().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiFutanDankai().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiKyuSochi().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiKyokaiso().clearValue();
        div.getFutanGendogakuNintei().getFutanGendogakuNinteiGekihenKanwa().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiShokuhi().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiUnitGataKoshitsu().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiUnitGataJunkoshitsu().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiJuraigataKoshitsuTokuyo().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiJuraigataKoshitsuRoken().clearValue();
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiTashoshitsu().clearValue();
    }

    /**
     * 負担限度額認定エリアの設定処理です。
     *
     * @param futanGendogakuNintei 介護保険負担限度額認定情報
     */
    public void set負担限度額認定エリア(FutanGendogakuNintei futanGendogakuNintei) {
        div.setHiddenRirekiNo(new RString(futanGendogakuNintei.get履歴番号()));
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiKetteiKubun().setValue(futanGendogakuNintei.get決定区分() == null
                || futanGendogakuNintei.get決定区分().isEmpty()
                        ? RString.EMPTY : KetteiKubun.toValue(futanGendogakuNintei.get決定区分()).get名称());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiShinseibi().setValue(futanGendogakuNintei.get申請年月日());
        div.getFutanGendogakuNintei().getFutanGendogakuNinteiKetteibi().setValue(futanGendogakuNintei.get決定年月日());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiTekiyobi().setValue(futanGendogakuNintei.get適用開始年月日());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiYukoKigen().setValue(futanGendogakuNintei.get適用終了年月日());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiShoninShinsaiRiyu().setValue(futanGendogakuNintei.get非承認理由());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiShinseiRiyu().setValue(
                futanGendogakuNintei.get申請理由区分() == null || futanGendogakuNintei.get申請理由区分().isEmpty()
                        ? RString.EMPTY : ShinseiRiyuKubun.toValue(futanGendogakuNintei.get申請理由区分()).get名称());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiFutanDankai().setValue(
                futanGendogakuNintei.get利用者負担段階() == null || futanGendogakuNintei.get利用者負担段階().isEmpty()
                        ? RString.EMPTY : RiyoshaFutanDankai.toValue(futanGendogakuNintei.get利用者負担段階()).get名称());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiKyuSochi().setValue(
                futanGendogakuNintei.get旧措置者区分() == null || futanGendogakuNintei.get旧措置者区分().isEmpty()
                        ? RString.EMPTY : KyuSochishaKubun.toValue(futanGendogakuNintei.get旧措置者区分()).get名称());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiKyokaiso().setValue(futanGendogakuNintei.is境界層該当者区分() ? 該当 : 非該当);
        div.getFutanGendogakuNintei().getFutanGendogakuNinteiGekihenKanwa().setValue(futanGendogakuNintei.is激変緩和措置対象者区分() ? 対象者 : 対象者以外);
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiShokuhi().setValue(futanGendogakuNintei.get食費負担限度額());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiUnitGataKoshitsu().setValue(futanGendogakuNintei.getユニット型個室());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiUnitGataJunkoshitsu().setValue(futanGendogakuNintei.getユニット型準個室());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiJuraigataKoshitsuTokuyo().setValue(futanGendogakuNintei.get従来型個室_特養等());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiJuraigataKoshitsuRoken().setValue(futanGendogakuNintei.get従来型個室_老健_療養等());
        div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiTashoshitsu().setValue(futanGendogakuNintei.get多床室());
    }

    private void クリア訪問介護利用者負担額減額エリア() {
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun().clearValue();
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuShinseibi().clearValue();
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuKetteibi().clearValue();
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuTekiyobi().clearValue();
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuYukoKigen().clearValue();
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu().clearValue();
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun().clearValue();
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu().clearValue();
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo().clearValue();
    }

    /**
     * 訪問介護利用者負担額減額エリアの設定処理です。
     *
     * @param homonKaigoRiyoshaFutangaku 訪問介護利用者負担額減額情報
     */
    public void set訪問介護利用者負担額減額エリア(HomonKaigoRiyoshaFutangakuGengaku homonKaigoRiyoshaFutangaku) {
        div.setHiddenRirekiNo(new RString(homonKaigoRiyoshaFutangaku.get履歴番号()));
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun().
                setValue(homonKaigoRiyoshaFutangaku.get決定区分() == null || homonKaigoRiyoshaFutangaku.get決定区分().isEmpty()
                        ? RString.EMPTY : KetteiKubun.toValue(homonKaigoRiyoshaFutangaku.get決定区分()).get名称());
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuShinseibi().
                setValue(homonKaigoRiyoshaFutangaku.get申請年月日());
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuKetteibi().
                setValue(homonKaigoRiyoshaFutangaku.get決定年月日());
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuTekiyobi().
                setValue(homonKaigoRiyoshaFutangaku.get適用開始年月日());
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuYukoKigen().
                setValue(homonKaigoRiyoshaFutangaku.get適用終了年月日());
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu().
                setValue(homonKaigoRiyoshaFutangaku.get非承認理由());
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun().setValue(
                homonKaigoRiyoshaFutangaku.get法別区分() == null || homonKaigoRiyoshaFutangaku.get法別区分().isEmpty()
                        ? RString.EMPTY : HobetsuKubun.toValue(homonKaigoRiyoshaFutangaku.get法別区分()).get名称());
        if (homonKaigoRiyoshaFutangaku.get給付率() != null) {
            div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu().
                    setValue(new RString(homonKaigoRiyoshaFutangaku.get給付率().getColumnValue().toString()));
        } else {
            div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu().clearValue();
        }
        div.getHomonKaigoRiyoshaFutangakuGengaku().getTxtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo().
                setValue(homonKaigoRiyoshaFutangaku.get公費受給者番号());
    }

    private void クリア社会福祉法人等利用者負担軽減エリア() {
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKetteiKubun().clearValue();
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenShinseibi().clearValue();
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKetteibi().clearValue();
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenTekiyobi().clearValue();
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenYukoKigen().clearValue();
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu().clearValue();
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKeigenJiyu().clearValue();
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKeigenritsu().clearValue();
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKakuninNo().clearValue();
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei().clearValue();
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei().clearValue();
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei().clearValue();
    }

    /**
     * 社会福祉法人等利用者負担軽減エリアの設定処理です。
     *
     * @param shakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減情報
     */
    public void set社会福祉法人等利用者負担軽減エリア(ShakaifukuRiyoshaFutanKeigen shakaifukuRiyoshaFutanKeigen) {
        div.setHiddenRirekiNo(new RString(shakaifukuRiyoshaFutanKeigen.get履歴番号()));
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKetteiKubun().
                setValue(shakaifukuRiyoshaFutanKeigen.get決定区分() == null || shakaifukuRiyoshaFutanKeigen.get決定区分().isEmpty()
                        ? RString.EMPTY : KetteiKubun.toValue(shakaifukuRiyoshaFutanKeigen.get決定区分()).get名称());
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenShinseibi().
                setValue(shakaifukuRiyoshaFutanKeigen.get申請年月日());
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKetteibi().
                setValue(shakaifukuRiyoshaFutanKeigen.get決定年月日());
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenTekiyobi().
                setValue(shakaifukuRiyoshaFutanKeigen.get適用開始年月日());
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenYukoKigen().
                setValue(shakaifukuRiyoshaFutanKeigen.get適用終了年月日());
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu().
                setValue(shakaifukuRiyoshaFutanKeigen.get非承認理由());
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKeigenJiyu().
                setValue(shakaifukuRiyoshaFutanKeigen.get申請事由());
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKeigenritsu().setValue(
                new RString(shakaifukuRiyoshaFutanKeigen.get軽減率_分子().toString().concat("/").
                        concat(shakaifukuRiyoshaFutanKeigen.get軽減率_分母().toString())));
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKakuninNo().
                setValue(shakaifukuRiyoshaFutanKeigen.get確認番号());
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei().
                setValue(shakaifukuRiyoshaFutanKeigen.is居宅サービス限定() ? 該当 : 非該当);
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei().
                setValue(shakaifukuRiyoshaFutanKeigen.is居住費_食費のみ() ? 該当 : 非該当);
        div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei().
                setValue(shakaifukuRiyoshaFutanKeigen.is旧措置者ユニット型個室のみ() ? 該当 : 非該当);
    }

    private void クリア特別地域加算減免エリア() {
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenKetteiKubun().clearValue();
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenShinseibi().clearValue();
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenTekiyobi().clearValue();
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenShoninShinaiRiyu().clearValue();
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenKeigenritsu().clearValue();
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenKetteibi().clearValue();
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenYukoKigen().clearValue();
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenKakuninNo().clearValue();
    }

    /**
     * 特別地域加算減免エリアの設定処理です。
     *
     * @param tokubetsuchiikiKasanGemmen 特別地域加算減免情報
     */
    public void set特別地域加算減免エリア(TokubetsuchiikiKasanGemmen tokubetsuchiikiKasanGemmen) {
        div.setHiddenRirekiNo(new RString(tokubetsuchiikiKasanGemmen.get履歴番号()));
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenKetteiKubun().setValue(tokubetsuchiikiKasanGemmen.get決定区分() == null
                || tokubetsuchiikiKasanGemmen.get決定区分().isEmpty()
                        ? RString.EMPTY : KetteiKubun.toValue(tokubetsuchiikiKasanGemmen.get決定区分()).get名称());
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenShinseibi().setValue(tokubetsuchiikiKasanGemmen.get申請年月日());
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenTekiyobi().setValue(tokubetsuchiikiKasanGemmen.get適用開始年月日());
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenShoninShinaiRiyu().setValue(tokubetsuchiikiKasanGemmen.get非承認理由());
        if (tokubetsuchiikiKasanGemmen.get減額率() != null) {
            div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenKeigenritsu().
                    setValue(new RString(tokubetsuchiikiKasanGemmen.get減額率().getColumnValue().toString()));
        } else {
            div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenKeigenritsu().clearValue();
        }
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenKetteibi().setValue(tokubetsuchiikiKasanGemmen.get決定年月日());
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenYukoKigen().setValue(tokubetsuchiikiKasanGemmen.get適用終了年月日());
        div.getTokubetsuChilkiKasanGenmen().getTxtTokubetsuChilkiKasanGenmenKakuninNo().setValue(tokubetsuchiikiKasanGemmen.get確認番号());
    }

    /**
     * 認定証と通知書パネルを設定します。
     *
     * @param 決定区分 決定区分
     * @param 認定証title 認定証パネルのタイトル
     */
    public void set認定証(RString 決定区分, RString 認定証title) {
        div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().setDisplayNone(false);
        div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().setTitle(認定証title);
        if (KetteiKubun.承認する.getコード().equals(決定区分)) {
            div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().setDisabledPublishCheckBox(false);
            div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().setIsPublish(true);
            div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().getTxtKetteiTsuchiHakkoYMD().setDisabled(false);
            div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().getTxtKetteiTsuchiHakkoYMD().
                    setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        } else {
            div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().setDisabledPublishCheckBox(true);
            div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().setIsPublish(false);
            div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().getTxtKetteiTsuchiHakkoYMD().setDisabled(true);
            div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().getTxtKetteiTsuchiHakkoYMD().clearValue();
        }
    }

    private void set通知書(RString 通知書title, ReportId 通知書帳票ID) {
        try {
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().getCcdBunshoNo().initialize(通知書帳票ID);
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setDisplayNone(false);
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setTitle(通知書title);
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setIsPublish(true);
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().getTxtHenkoTsuchiHakkoYMD().
                    setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        } catch (ApplicationException e) {
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setDisplayNone(false);
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setTitle(通知書title);
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setIsPublish(true);
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().getTxtHenkoTsuchiHakkoYMD().
                    setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        }
    }

    /**
     * 介護保険負担限度額認定のenumクラスです。
     */
    public enum GemmenGengakuShoHakkoEnum {

        /**
         * is世帯初期化
         */
        is世帯初期化,
        /**
         * 減免減額種類
         */
        減免減額種類,
        /**
         * 利用者負担額減額List
         */
        利用者負担額減額List,
        /**
         * 負担限度額認定List
         */
        負担限度額認定List,
        /**
         * 社会福祉法人等利用者負担軽減List
         */
        社会福祉法人等利用者負担軽減List,
        /**
         * 訪問介護利用者負担額減額List
         */
        訪問介護利用者負担額減額List,
        /**
         * 特別地域加算減免
         */
        特別地域加算減免List;
    }

}
