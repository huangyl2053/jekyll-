/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020004;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD209012.DBD209012_KyufuGakuGengakuKanriListParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.shiharaihohohenko.kyufugengakukanrilist.TaishoKubun;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020004.KyufugakuGengakuKanriListDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付額減額管理リストのハンドラークラスです。
 *
 * @reamsid_L DBD-3800-040 b_zhengs
 */
public class KyufugakuGengakuKanriListHandler {

    private final KyufugakuGengakuKanriListDiv div;
    private static final RString 全登録者 = new RString("0");
    private static final RString 全登録者以外 = new RString("1");

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        div.getChushutuJoken().getTxtKijunDate().clearValue();
        div.getChushutuJoken().getRadTaisho().setSelectedKey(全登録者);
        div.getChkTsuchishoMihakko().setDisabled(true);
        div.getChkGengakuTekiyochuSha().setDisabled(true);
        div.getChkGengakuShuryoDate().setDisabled(true);
        div.getTxtGengakuTekiyoChushaKijunDate().setDisabled(true);
        div.getTxtGengakuShuryoRange().setDisabled(true);
        div.getTxtGengakuTekiyoChushaKijunDate().clearValue();
        div.getTxtGengakuShuryoRange().clearFromValue();
        div.getTxtGengakuShuryoRange().clearToValue();
        div.getChushutuJoken().getChkOutputsHokenryoKannosha().setDisabled(false);
        List<RString> keys = new ArrayList<>();
        div.getChkTsuchishoMihakko().setSelectedItemsByKey(keys);
        List<RString> keys1 = new ArrayList<>();
        div.getChkGengakuTekiyochuSha().setSelectedItemsByKey(keys1);
        List<RString> keys2 = new ArrayList<>();
        div.getChkGengakuShuryoDate().setSelectedItemsByKey(keys2);
        List<RString> keys3 = new ArrayList<>();
        div.getChushutuJoken().getChkOutputsHokenryoKannosha().setSelectedItemsByKey(keys3);
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200009.getReportId());
    }

    /**
     * 登録者を選択します。
     *
     */
    public void onChange_chushutuJoken() {

        if (全登録者.equals(div.getChushutuJoken().getRadTaisho().getSelectedKey())) {
            div.getChkTsuchishoMihakko().setDisabled(true);
            div.getChkGengakuTekiyochuSha().setDisabled(true);
            div.getChkGengakuShuryoDate().setDisabled(true);
            div.getTxtGengakuTekiyoChushaKijunDate().setDisabled(true);
            div.getTxtGengakuShuryoRange().setDisabled(true);
            div.getTxtGengakuTekiyoChushaKijunDate().clearValue();
            div.getTxtGengakuShuryoRange().clearFromValue();
            div.getTxtGengakuShuryoRange().clearToValue();
            List<RString> keys = new ArrayList<>();
            div.getChkTsuchishoMihakko().setSelectedItemsByKey(keys);
            List<RString> keys1 = new ArrayList<>();
            div.getChkGengakuTekiyochuSha().setSelectedItemsByKey(keys1);
            List<RString> keys2 = new ArrayList<>();
            div.getChkGengakuShuryoDate().setSelectedItemsByKey(keys2);
        } else if (全登録者以外.equals(div.getChushutuJoken().getRadTaisho().getSelectedKey())) {
            div.getChkTsuchishoMihakko().setDisabled(false);
            div.getChkGengakuTekiyochuSha().setDisabled(false);
            div.getChkGengakuShuryoDate().setDisabled(false);
        }
    }

    /**
     * 「減額適用中者」チェックボックスの選択します。
     *
     */
    public void onClick_chkGengakuTekiyochuSha() {
        if (div.getChkGengakuTekiyochuSha().isAllSelected()) {
            div.getTxtGengakuTekiyoChushaKijunDate().setDisabled(false);
        } else {
            div.getTxtGengakuTekiyoChushaKijunDate().setDisabled(true);
            div.getTxtGengakuTekiyoChushaKijunDate().clearValue();
        }

    }

    /**
     * 「減額終了日抽出」チェックボックスの選択
     *
     */
    public void onChange_chkGengakuShuryoDate() {
        if (div.getChkGengakuShuryoDate().isAllSelected()) {
            div.getTxtGengakuShuryoRange().setDisabled(false);
        } else {
            div.getTxtGengakuShuryoRange().setDisabled(true);
            div.getTxtGengakuShuryoRange().clearFromValue();
            div.getTxtGengakuShuryoRange().clearToValue();
        }

    }

    /**
     * バッチ用パラメータを作成します。
     *
     * @return CreateKyufugakuGengakuKanriListBatchParameter 給付額減額管理リスト_バッチ用のパラメータ
     */
    public DBD209012_KyufuGakuGengakuKanriListParameter batchParameter() {
        DBD209012_KyufuGakuGengakuKanriListParameter tempData = new DBD209012_KyufuGakuGengakuKanriListParameter();
        tempData.set基準日(日期類型変更(div.getChushutuJoken().getTxtKijunDate().getValue()));
        tempData.set対象区分(対象区分に変更(div.getChushutuJoken().getRadTaisho().getSelectedKey()));
        tempData.set通知書未発行者抽出(div.getChkTsuchishoMihakko().isAllSelected());
        tempData.set減額適用中者抽出(div.getChkGengakuTekiyochuSha().isAllSelected());
        tempData.set減額適用中者抽出基準日(日期類型変更(div.getTxtGengakuTekiyoChushaKijunDate().getValue()));
        tempData.set減額終了日抽出(div.getChkGengakuShuryoDate().isAllSelected());
        tempData.set減額終了日範囲From(日期類型変更(div.getTxtGengakuShuryoRange().getFromValue()));
        tempData.set減額終了日範囲To(日期類型変更(div.getTxtGengakuShuryoRange().getToValue()));
        tempData.set保険料完納者出力(div.getChushutuJoken().getChkOutputsHokenryoKannosha().isAllSelected());
        tempData.set改頁出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());
        tempData.set帳票ID(ReportIdDBD.DBD200009.getReportId());
        return tempData;
    }

    /**
     * コンストラクタです。
     *
     * @param div KyufugakuGengakuKanriListDiv
     */
    public KyufugakuGengakuKanriListHandler(KyufugakuGengakuKanriListDiv div) {
        this.div = div;
    }

    private FlexibleDate 日期類型変更(RDate 変更前日期) {
        if (変更前日期 != null) {
            return new FlexibleDate(変更前日期.toDateString());
        }
        return FlexibleDate.EMPTY;
    }

    private TaishoKubun 対象区分に変更(RString 対象区分) {
        if (全登録者.equals(対象区分)) {
            return TaishoKubun.全登録者;
        }
        return TaishoKubun.全登録者以外;
    }
}
