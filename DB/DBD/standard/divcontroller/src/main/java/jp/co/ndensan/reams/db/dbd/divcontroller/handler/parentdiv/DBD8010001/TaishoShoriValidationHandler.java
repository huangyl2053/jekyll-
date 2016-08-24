/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdWarningMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001.TaishoShoriPanelDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 非課税年金対象者情報アップロード画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-4920-010 lit
 */
public class TaishoShoriValidationHandler {

    private final TaishoShoriPanelDiv div;
    private static final RString 処理コード_年次 = new RString("0");
    private static final RString 処理コード_月次 = new RString("1");
    private static final int 作成年月日開始位置 = 9;
    private static final int 作成年月日終了位置 = 17;
    private static final int 作成年月終了位置 = 15;
    private static final int 作成年終了位置 = 13;

    /**
     * コンストラクタです。
     *
     * @param div TaishoShoriPanelDiv
     */
    public TaishoShoriValidationHandler(TaishoShoriPanelDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TaishoShoriValidator(div).validate();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validateファイル値() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TaishoShoriValidator(div).validateファイル値();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validateファイル内容() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TaishoShoriValidator(div).validateファイル内容();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate調定年度() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TaishoShoriValidator(div).validate調定年度();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    /**
     * ボタンクリック時のバリデーションチェックです
     *
     * @return 作成年月日Message
     */
    public Message validate作成年月日() {

        RString 処理コード = div.getDgTaishoShoriItchiran().getSelectedItems().get(0).getHdnShoriCode();
        RString 作成年月日 = new FlexibleDate(div.getHdnLine().substring(作成年月日開始位置, 作成年月日終了位置))
                .wareki().toDateString();
        RString 作成年月 = div.getHdnLine().substring(作成年月日開始位置, 作成年月終了位置);
        RString 処理年度 = div.getDdlShoriNendo().getSelectedKey();

        if (処理コード.equals(処理コード_年次)) {
            RString 作成年 = div.getHdnLine().substring(作成年月日開始位置, 作成年終了位置);
            if (!作成年.equals(処理年度)) {
                return DbdWarningMessages.非課税年金年次取込確認.getMessage(ButtonSelectPattern.OKCancel).replace(
                        作成年月日.toString(),
                        new FlexibleYear(作成年).wareki().toDateString().toString());
            }

        } else if (処理コード.equals(処理コード_月次)) {
            RString 年度終了月 = DbBusinessConfig.get(ConfigNameDBD.非課税年金対象者情報_月次処理年度終了月,
                    RDate.getNowDate(), SubGyomuCode.DBD介護受給);
            RString 選択月 = div.getDgTaishoShoriItchiran().getSelectedItems().get(0).getHdnTukiCode().substring(1);
            RString 処理年月;
            if (年度終了月.compareTo(選択月) < 0) {
                処理年月 = 処理年度.concat(選択月);
            } else {
                処理年月 = new FlexibleYear(処理年度).plusYear(1).toDateString().concat(選択月);
            }
            RString 通常作成年月 = new FlexibleYearMonth(処理年月).minusMonth(1).toDateString();

            if (!通常作成年月.equals(作成年月)) {
                return DbdWarningMessages.非課税年金月次取込確認.getMessage(ButtonSelectPattern.OKCancel).replace(
                        作成年月日.toString(),
                        new FlexibleYearMonth(処理年月).wareki().toDateString().toString(),
                        new FlexibleYearMonth(通常作成年月).wareki().toDateString().toString());

            }
        }
        return null;

    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(TaishoShoriValidationMessage.調定年度チェック, new ArrayList<ViewControl>())
                .add(TaishoShoriValidationMessage.処理状態チェック_処理済, get対象一覧())
                .add(TaishoShoriValidationMessage.処理状態チェック_処理なし, get対象一覧())
                .add(TaishoShoriValidationMessage.アップロードファイル未指定チェック, getアップロードファイル())
                .add(TaishoShoriValidationMessage.編集なしチェック, get設定対象一覧())
                .add(TaishoShoriValidationMessage.市町村コードチェック, getアップロードファイル())
                .add(TaishoShoriValidationMessage.年次ファイル通知内容チェック, getアップロードファイル())
                .add(TaishoShoriValidationMessage.月次ファイル通知内容チェック, getアップロードファイル())
                .build();
    }

    private List<ViewControl> get対象一覧() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getDgTaishoShoriItchiran());
        return viewControls;
    }

    private List<ViewControl> get設定対象一覧() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getDgShoriSettei());
        return viewControls;
    }

    private List<ViewControl> getアップロードファイル() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getUplTaishoFuairu());
        return viewControls;
    }
}
