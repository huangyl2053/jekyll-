/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0210011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210011.TsukibetsuSuiihyoSakuseiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 月別推移表のHandlerクラスです。
 */
public class TsukibetsuSuiihyoSakuseiHandler {

    private final TsukibetsuSuiihyoSakuseiDiv div;
    private static final RString SHICHOSONCODE_120 = new RString("120");
    private static final RString SHICHOSONCODE_220 = new RString("220");
    private static final RString SHICHOSONCODE_111 = new RString("111");
    private static final RString SHICHOSONCODE_112 = new RString("112");
    private static final RString SHICHOSONCODE_211 = new RString("211");
    private static final RString 年齢 = new RString("nenrei");
    private static final RString 生年月日 = new RString("umareYMD");
    private static final RString 空白文字 = new RString("");

    /**
     * コンストラクタです。
     *
     * @param div 月別推移表のクラスファイル
     */
    public TsukibetsuSuiihyoSakuseiHandler(TsukibetsuSuiihyoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onload() {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(
                GyomuBunrui.介護事務);
        if (new Code(SHICHOSONCODE_120).equals(shichosonSecurityJoho.get導入形態コード())
                || new Code(SHICHOSONCODE_220).equals(shichosonSecurityJoho.get導入形態コード())) {
            // 状態１　初期化状態（単一保険者）
            setヘッダエリア();
            set抽出条件エリア();
            // div.getCcdChikuShichosonSelect().
            // 選択対象==全て
        }
        if (new Code(SHICHOSONCODE_111).equals(shichosonSecurityJoho.get導入形態コード())
                || new Code(SHICHOSONCODE_112).equals(shichosonSecurityJoho.get導入形態コード())
                || new Code(SHICHOSONCODE_211).equals(shichosonSecurityJoho.get導入形態コード())) {
            // 状態２　初期化状態（広域保険者）
            setヘッダエリア();
            set抽出条件エリア();
            // 市町村==全市町村
        }

        // TODO ビジネス設計_DBUMN00000_市町村情報セキュリティ取得.xlsxの「市町村セキュリティ情報を取得する」を呼び出す この機能は4次協同設計です。
    }

    /**
     * バッチパラメータを作成します。
     *
     * @param div 月別推移表のクラスファイル
     * @return CreateTsukibetsuSuiihyoBatchParameter 月別推移表作成_バッチ用のパラメータ
     */
    public CreateTsukibetsuSuiihyoBatchParameter batchParameter(TsukibetsuSuiihyoSakuseiDiv div) {
        CreateTsukibetsuSuiihyoBatchParameter batchParameter = new CreateTsukibetsuSuiihyoBatchParameter();
        batchParameter.setChoteiNendo(new FlexibleYear(div.getTxtChoteiNendo().getValue().getYear().toString()));
        RStringBuilder buf = new RStringBuilder();
        buf.append(div.getTxtChoteiKijunYMD().getValue());
        buf.append(RTime.now().toString());
        batchParameter.setChoteiKijunNichiji(buf.toRString());
        batchParameter.setKakutukiShikakuKijunNichi(div.getDdShikakuKijunD().getSelectedValue());
        if (年齢.equals(div.getRadNenrei().getSelectedKey())) {
            batchParameter.setAgeFlg(true);
        } else {
            batchParameter.setAgeFlg(false);
        }
        batchParameter.setAgeStart(new RString(div.getTxtNenreiSt().toString()));
        batchParameter.setAgeEnd(new RString(div.getTxtNenreiEd().toString()));
        batchParameter.setAgeKijunNi(div.getTxtNenreiKijunYMD().getValue().toDateString());
        if (生年月日.equals(div.getRadUmareYMD().getSelectedKey())) {
            batchParameter.setSeinengappiYMD_Flg(true);
        } else {
            batchParameter.setSeinengappiYMD_Flg(false);
        }
        batchParameter.setSeinengappiYMDStart(div.getTxtUmareSt().getValue().toDateString());
        batchParameter.setSeinengappiYMDEnd(div.getTxtUmareEd().getValue().toDateString());
        // TODO 介護地区・市町村選択共有子Divを呼び出す
//        batchParameter.setSentakuTaisho();
//        batchParameter.setSentakuKekkaList();
//        batchParameter.setShichosonCode();
//        batchParameter.setShichosonMeisho();
//        batchParameter.setKyuShichosonCode();
//        batchParameter.setKyuShichosonMeisho();
        return batchParameter;
    }

    private void setヘッダエリア() {
        div.getTxtChoteiNendo().setValue(new RDate(BusinessConfig.get(ConfigNameDBB.日付関連_調定年度).toString()));
        div.getTxtChoteiKijunYMD().setValue(RDate.getNowDate());
    }

    private void set抽出条件エリア() {
        set各月資格基準日();
        div.getRadNenrei().setSelectedKey(年齢);
        div.getTxtUmareSt().setDisabled(true);
        div.getTxtUmareEd().setDisabled(true);

    }

    private void set各月資格基準日() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (int i = 0; i < RDate.getNowDate().getLastDay(); i++) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString(空白文字.toString() + i));
            dataSource.setValue(new RString(空白文字.toString() + i));
            dataSourceList.add(dataSource);
        }
        div.getDdShikakuKijunD().setDataSource(dataSourceList);
        for (int i = 0; i < RDate.getNowDate().getLastDay(); i++) {
            if (i == RDate.getNowDate().getDayValue()) {
                div.getDdShikakuKijunD().setSelectedKey(new RString(空白文字.toString() + i));
            }
        }

    }

    /**
     * 年齢開始に入力した値が65より小さい場合、エラーとする。
     *
     * @return validationMessages
     */
    public ValidationMessageControlPairs 年齢65歳未満チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.年齢65歳未満));
        return validationMessages;
    }

    /**
     * 抽出開始年齢大小不整合チェック場合、エラーとする。
     *
     * @return validationMessages
     */
    public ValidationMessageControlPairs 抽出開始年齢大小不整合チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.抽出開始年齢大小不整合));
        return validationMessages;
    }

    /**
     * 抽出開始生年月日大小不整合チェック場合、エラーとする。
     *
     * @return validationMessages
     */
    public ValidationMessageControlPairs 抽出開始生年月日大小不整合チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.抽出開始生年月日大小不整合));
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        年齢65歳未満(DbbErrorMessages.年齢65歳未満),
        抽出開始年齢大小不整合(DbbErrorMessages.抽出開始年齢大小不整合, "抽出開始年齢", "抽出終了年齢"),
        抽出開始生年月日大小不整合(DbbErrorMessages.抽出開始生年月日大小不整合, "抽出開始生年月日", "抽出終了生年月日");

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
