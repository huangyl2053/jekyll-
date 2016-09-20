/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110004;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE013001.DBE013001_IkenshoInfoPrintParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110004.HakkoJokenSyujiiIkensyoDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBE0110004_主治医意見書に関する帳票発行handlerクラスです
 *
 * @reamsid_L DBE-1390-070 xuyongchao
 */
public class HakkoJokenSyujiiIkensyoHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final List<RString> SELECT_LIST = new ArrayList<>();
    private final HakkoJokenSyujiiIkensyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HakkoJokenSyujiiIkensyoHandler(HakkoJokenSyujiiIkensyoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 主治医意見書未提出者一覧フラグ 遷移元画面から受け取った引数
     * @param 主治医意見書５項目確認一覧表フラグ 遷移元画面から受け取った引数
     * @param 主治医意見書依頼未処理者一覧表フラグ 遷移元画面から受け取った引数
     * @param 主治医意見書作成依頼変更者一覧表フラグ 遷移元画面から受け取った引数
     * @param 主治医意見書依頼済み一覧表フラグ 遷移元画面から受け取った引数
     * @param 主治医意見書作成料請求一覧表フラグ 遷移元画面から受け取った引数
     */
    public void onLoad(boolean 主治医意見書未提出者一覧フラグ, boolean 主治医意見書５項目確認一覧表フラグ,
            boolean 主治医意見書依頼未処理者一覧表フラグ, boolean 主治医意見書作成依頼変更者一覧表フラグ, boolean 主治医意見書依頼済み一覧表フラグ,
            boolean 主治医意見書作成料請求一覧表フラグ) {
        checkPanel(主治医意見書未提出者一覧フラグ, 主治医意見書５項目確認一覧表フラグ, 主治医意見書依頼未処理者一覧表フラグ,
                主治医意見書作成依頼変更者一覧表フラグ, 主治医意見書依頼済み一覧表フラグ, 主治医意見書作成料請求一覧表フラグ);
        SELECT_LIST.clear();
        if (主治医意見書未提出者一覧フラグ) {
            div.getMiteishutsushaIchiranJoken().setIsOpen(true);
            SELECT_LIST.add(SELECT_KEY0);
            div.getChkMiteishutsushaIchiran().setSelectedItemsByKey(SELECT_LIST);
            SELECT_LIST.clear();
        }
        if (主治医意見書５項目確認一覧表フラグ) {
            div.getKakuninIchiranhyoJoken().setIsOpen(true);
            SELECT_LIST.add(SELECT_KEY0);
            div.getChkKakuninIchiranhyo().setSelectedItemsByKey(SELECT_LIST);
            SELECT_LIST.clear();
        }
        if (主治医意見書依頼未処理者一覧表フラグ) {
            div.getIraiMishorishaIchiranhyoJoken().setIsOpen(true);
            SELECT_LIST.add(SELECT_KEY0);
            div.getChkIraiMishorishaIchiranhyo().setSelectedItemsByKey(SELECT_LIST);
            SELECT_LIST.clear();
        }
        if (主治医意見書作成依頼変更者一覧表フラグ) {
            div.getSakuseiIraiHenkoushaIchiranhyoJoken().setIsOpen(true);
            SELECT_LIST.add(SELECT_KEY0);
            div.getChkSakuseiIraiHenkoushaIchiranhyoJoken().setSelectedItemsByKey(SELECT_LIST);
            SELECT_LIST.clear();
        }
        if (主治医意見書依頼済み一覧表フラグ) {
            div.getIraiZumiIchiranhyoJoken().setIsOpen(true);
            SELECT_LIST.add(SELECT_KEY0);
            div.getChkIraiZumiIchiranhyoJoken().setSelectedItemsByKey(SELECT_LIST);
            SELECT_LIST.clear();
        }
        if (主治医意見書作成料請求一覧表フラグ) {
            div.getSakuseiryoSeikyuIchiranhyoJoken().setIsOpen(true);
            SELECT_LIST.add(SELECT_KEY0);
            div.getChkSakuseiryoSeikyuIchiranhyo().setSelectedItemsByKey(SELECT_LIST);
            SELECT_LIST.clear();
        }
    }

    /**
     * 作成条件活性または非活性処理です。
     *
     * @param 主治医意見書未提出者一覧フラグ 遷移元画面から受け取った引数
     * @param 主治医意見書５項目確認一覧表フラグ 遷移元画面から受け取った引数
     * @param 主治医意見書依頼未処理者一覧表フラグ 遷移元画面から受け取った引数
     * @param 主治医意見書作成依頼変更者一覧表フラグ 遷移元画面から受け取った引数
     * @param 主治医意見書依頼済み一覧表フラグ 遷移元画面から受け取った引数
     * @param 主治医意見書作成料請求一覧表フラグ 遷移元画面から受け取った引数
     */
    public void checkPanel(boolean 主治医意見書未提出者一覧フラグ, boolean 主治医意見書５項目確認一覧表フラグ,
            boolean 主治医意見書依頼未処理者一覧表フラグ, boolean 主治医意見書作成依頼変更者一覧表フラグ, boolean 主治医意見書依頼済み一覧表フラグ,
            boolean 主治医意見書作成料請求一覧表フラグ) {
        if (!主治医意見書未提出者一覧フラグ) {
            div.getRadJoken1().setDisabled(true);
            div.getTxtIraiNisu().clearValue();
            div.getTxtIraiNisu().setDisabled(true);
            div.getTxtShinseiYMD1().clearFromValue();
            div.getTxtShinseiYMD1().clearToValue();
            div.getTxtShinseiYMD1().setDisabled(true);
            div.getMiteishutsushaIchiranJoken().setIsOpen(false);
        } else {
            if (div.getRadJoken1().getSelectedKey().contains(SELECT_KEY0)) {
                div.getTxtShinseiYMD1().clearFromValue();
                div.getTxtShinseiYMD1().clearToValue();
                div.getTxtShinseiYMD1().setDisabled(true);
            } else {
                div.getTxtIraiNisu().clearValue();
                div.getTxtIraiNisu().setDisabled(true);
            }
        }
        if (!主治医意見書５項目確認一覧表フラグ) {
            div.getRadJoken2().setDisabled(true);
            div.getTxtShinsakai2().clearValue();
            div.getTxtShinsakai2().setDisabled(true);
            div.getKakuninIchiranhyoJoken().setIsOpen(false);
        } else {
            if (div.getRadJoken2().getSelectedKey().contains(SELECT_KEY0)) {
                div.getTxtShinsakai2().clearValue();
                div.getTxtShinsakai2().setDisabled(true);
            }
        }
        if (!主治医意見書依頼未処理者一覧表フラグ) {
            div.getRadJoken3().setDisabled(true);
            div.getTxtShinsaYMD3().clearFromValue();
            div.getTxtShinsaYMD3().clearToValue();
            div.getTxtShinsaYMD3().setDisabled(true);
            div.getIraiMishorishaIchiranhyoJoken().setIsOpen(false);
        } else {
            if (div.getRadJoken3().getSelectedKey().contains(SELECT_KEY0)) {
                div.getTxtShinsaYMD3().clearFromValue();
                div.getTxtShinsaYMD3().clearToValue();
                div.getTxtShinsaYMD3().setDisabled(true);
            }
        }
        if (!主治医意見書作成依頼変更者一覧表フラグ) {
            div.getTxtShinseiYMD4().clearFromValue();
            div.getTxtShinseiYMD4().clearToValue();
            div.getTxtShinseiYMD4().setDisabled(true);
            div.getSakuseiIraiHenkoushaIchiranhyoJoken().setIsOpen(false);

        }
        if (!主治医意見書依頼済み一覧表フラグ) {
            div.getRadJoken5().setDisabled(true);
            div.getTxtShoriYMD5().clearFromValue();
            div.getTxtShoriYMD5().clearToValue();
            div.getTxtShoriYMD5().setDisabled(true);
            div.getTxtShinseiYMD5().clearFromValue();
            div.getTxtShinseiYMD5().clearToValue();
            div.getTxtShinseiYMD5().setDisabled(true);
            div.getIraiZumiIchiranhyoJoken().setIsOpen(false);
        } else {
            if (div.getRadJoken5().getSelectedKey().contains(SELECT_KEY0)) {
                div.getTxtShinseiYMD5().clearFromValue();
                div.getTxtShinseiYMD5().clearToValue();
                div.getTxtShinseiYMD5().setDisabled(true);
            } else {
                div.getTxtShoriYMD5().clearFromValue();
                div.getTxtShoriYMD5().clearToValue();
                div.getTxtShoriYMD5().setDisabled(true);
            }
        }
        if (!主治医意見書作成料請求一覧表フラグ) {
            div.getRadSeikyuIchiranJoken().setDisabled(true);
            div.getTxtSeikyuIchiranShoriYMD().clearFromValue();
            div.getTxtSeikyuIchiranShoriYMD().clearToValue();
            div.getTxtSeikyuIchiranShoriYMD().setDisabled(true);
            div.getTxtJuryoYMD().clearFromValue();
            div.getTxtJuryoYMD().clearToValue();
            div.getTxtJuryoYMD().setDisabled(true);
            div.getSakuseiryoSeikyuIchiranhyoJoken().setIsOpen(false);
        } else {
            if (div.getRadSeikyuIchiranJoken().getSelectedKey().contains(SELECT_KEY0)) {
                div.getTxtJuryoYMD().clearFromValue();
                div.getTxtJuryoYMD().clearToValue();
                div.getTxtJuryoYMD().setDisabled(true);
            } else {
                div.getTxtSeikyuIchiranShoriYMD().clearFromValue();
                div.getTxtSeikyuIchiranShoriYMD().clearToValue();
                div.getTxtSeikyuIchiranShoriYMD().setDisabled(true);
            }
        }
    }

    /**
     * バッチ用パラメータクラスを作成します。
     *
     * @return ikenshoJohoPrintBatchParameter
     */
    public DBE013001_IkenshoInfoPrintParameter setBatchParameter() {
        boolean 主治医意見書未提出者一覧フラグ = div.getChkMiteishutsushaIchiran().getSelectedKeys().contains(SELECT_KEY0);
        boolean 主治医意見書５項目確認一覧表フラグ = div.getChkKakuninIchiranhyo().getSelectedKeys().contains(SELECT_KEY0);
        boolean 主治医意見書依頼未処理者一覧表フラグ = div.getChkIraiMishorishaIchiranhyo().getSelectedKeys().contains(SELECT_KEY0);
        boolean 主治医意見書作成依頼変更者一覧表フラグ = div.getChkSakuseiIraiHenkoushaIchiranhyoJoken().getSelectedKeys().contains(SELECT_KEY0);
        boolean 主治医意見書依頼済み一覧表フラグ = div.getChkIraiZumiIchiranhyoJoken().getSelectedKeys().contains(SELECT_KEY0);
        boolean 主治医意見書作成料請求一覧表フラグ = div.getChkSakuseiryoSeikyuIchiranhyo().getSelectedKeys().contains(SELECT_KEY0);
        RString 主治医意見書未提出者一覧作成条件 = null;
        RString 主治医意見書未提出者一覧依頼日数 = null;
        FlexibleDate 主治医意見書未提出者一覧申請日From = null;
        FlexibleDate 主治医意見書未提出者一覧申請日To = null;
        RString 主治医意見書５項目確認一覧表作成条件 = null;
        RString 主治医意見書５項目確認一覧表審査会 = null;
        RString 主治医意見書依頼未処理者一覧表作成条件 = null;
        FlexibleDate 主治医意見書依頼未処理者一覧表申請日From = null;
        FlexibleDate 主治医意見書依頼未処理者一覧表申請日To = null;
        FlexibleDate 主治医意見書作成依頼変更者一覧表申請日From = null;
        FlexibleDate 主治医意見書作成依頼変更者一覧表申請日To = null;
        RString 主治医意見書依頼済み一覧表作成条件 = null;
        FlexibleDate 主治医意見書依頼済み一覧表処理日From = null;
        FlexibleDate 主治医意見書依頼済み一覧表処理日To = null;
        FlexibleDate 主治医意見書依頼済み一覧表申請日From = null;
        FlexibleDate 主治医意見書依頼済み一覧表申請日To = null;
        RString 主治医意見書作成料請求一覧表作成条件 = null;
        FlexibleDate 主治医意見書作成料請求一覧表処理日From = null;
        FlexibleDate 主治医意見書作成料請求一覧表処理日To = null;
        FlexibleDate 主治医意見書作成料請求一覧表受領日From = null;
        FlexibleDate 主治医意見書作成料請求一覧表受領日To = null;

        if (主治医意見書未提出者一覧フラグ) {
            if (div.getRadJoken1().getSelectedKey().contains(SELECT_KEY0)) {
                主治医意見書未提出者一覧作成条件 = new RString("1");
                主治医意見書未提出者一覧依頼日数 = div.getTxtIraiNisu().getText();
            } else {
                主治医意見書未提出者一覧作成条件 = new RString("2");
                主治医意見書未提出者一覧申請日From = new FlexibleDate(div.getTxtShinseiYMD1().getFromValue().toDateString());
                主治医意見書未提出者一覧申請日To = new FlexibleDate(div.getTxtShinseiYMD1().getToValue().toDateString());
            }
        }
        if (主治医意見書５項目確認一覧表フラグ) {
            if (div.getRadJoken2().getSelectedKey().contains(SELECT_KEY0)) {
                主治医意見書５項目確認一覧表作成条件 = new RString("1");
            } else {
                主治医意見書５項目確認一覧表作成条件 = new RString("2");
                主治医意見書５項目確認一覧表審査会 = div.getTxtShinsakai2().getText();
            }
        }
        if (主治医意見書依頼未処理者一覧表フラグ) {
            if (div.getTxtShinsaYMD3().isDisabled()) {
                主治医意見書依頼未処理者一覧表作成条件 = new RString("1");
            } else {
                主治医意見書依頼未処理者一覧表作成条件 = new RString("2");
                主治医意見書依頼未処理者一覧表申請日From = new FlexibleDate(div.getTxtShinsaYMD3().getFromValue().toDateString());
                主治医意見書依頼未処理者一覧表申請日To = new FlexibleDate(div.getTxtShinsaYMD3().getToValue().toDateString());
            }
        }
        if (主治医意見書作成依頼変更者一覧表フラグ) {
            主治医意見書作成依頼変更者一覧表申請日From = new FlexibleDate(div.getTxtShinseiYMD4().getFromValue().toDateString());
            主治医意見書作成依頼変更者一覧表申請日To = new FlexibleDate(div.getTxtShinseiYMD4().getToValue().toDateString());
        }
        if (主治医意見書依頼済み一覧表フラグ) {
            if (div.getRadJoken5().getSelectedKey().contains(SELECT_KEY0)) {
                主治医意見書依頼済み一覧表作成条件 = new RString("1");
                主治医意見書依頼済み一覧表処理日From = new FlexibleDate(div.getTxtShoriYMD5().getFromValue().toDateString());
                主治医意見書依頼済み一覧表処理日To = new FlexibleDate(div.getTxtShoriYMD5().getToValue().toDateString());
            } else {
                主治医意見書依頼済み一覧表作成条件 = new RString("2");
                主治医意見書依頼済み一覧表申請日From = new FlexibleDate(div.getTxtShinseiYMD5().getFromValue().toDateString());
                主治医意見書依頼済み一覧表申請日To = new FlexibleDate(div.getTxtShinseiYMD5().getToValue().toDateString());
            }
        }
        if (主治医意見書作成料請求一覧表フラグ) {
            if (div.getRadSeikyuIchiranJoken().getSelectedKey().contains(SELECT_KEY0)) {
                主治医意見書作成料請求一覧表作成条件 = new RString("1");
                主治医意見書作成料請求一覧表処理日From = new FlexibleDate(div.getTxtSeikyuIchiranShoriYMD().getFromValue().toDateString());
                主治医意見書作成料請求一覧表処理日To = new FlexibleDate(div.getTxtSeikyuIchiranShoriYMD().getToValue().toDateString());
            } else {
                主治医意見書作成料請求一覧表作成条件 = new RString("2");
                主治医意見書作成料請求一覧表受領日From = new FlexibleDate(div.getTxtJuryoYMD().getFromValue().toDateString());
                主治医意見書作成料請求一覧表受領日To = new FlexibleDate(div.getTxtJuryoYMD().getToValue().toDateString());
            }
        }
        DBE013001_IkenshoInfoPrintParameter ikenshoJohoPrintBatchParameter = new DBE013001_IkenshoInfoPrintParameter(
                主治医意見書未提出者一覧フラグ,
                主治医意見書未提出者一覧作成条件,
                主治医意見書未提出者一覧依頼日数,
                主治医意見書未提出者一覧申請日From,
                主治医意見書未提出者一覧申請日To,
                主治医意見書５項目確認一覧表フラグ,
                主治医意見書５項目確認一覧表作成条件,
                主治医意見書５項目確認一覧表審査会,
                主治医意見書依頼未処理者一覧表フラグ,
                主治医意見書依頼未処理者一覧表作成条件,
                主治医意見書依頼未処理者一覧表申請日From,
                主治医意見書依頼未処理者一覧表申請日To,
                主治医意見書作成依頼変更者一覧表フラグ,
                主治医意見書作成依頼変更者一覧表申請日From,
                主治医意見書作成依頼変更者一覧表申請日To,
                主治医意見書依頼済み一覧表フラグ,
                主治医意見書依頼済み一覧表作成条件,
                主治医意見書依頼済み一覧表処理日From,
                主治医意見書依頼済み一覧表処理日To,
                主治医意見書依頼済み一覧表申請日From,
                主治医意見書依頼済み一覧表申請日To,
                主治医意見書作成料請求一覧表フラグ,
                主治医意見書作成料請求一覧表作成条件,
                主治医意見書作成料請求一覧表処理日From,
                主治医意見書作成料請求一覧表処理日To,
                主治医意見書作成料請求一覧表受領日From,
                主治医意見書作成料請求一覧表受領日To);
        return ikenshoJohoPrintBatchParameter;
    }
}
