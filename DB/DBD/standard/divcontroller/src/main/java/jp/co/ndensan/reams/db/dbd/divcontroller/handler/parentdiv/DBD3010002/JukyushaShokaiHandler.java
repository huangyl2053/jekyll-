/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD3010002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.jukyushokai.JukyuShokaiShinseiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.jukyushokai.JukyuShokaiShinseiNinteiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.jukyushokai.ServiceJukyuJokyo;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002.DBD3010002StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002.JukyushaShokaiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002.dgNinteiRireki_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002.dgShiteiServiceShurui_Row;
import jp.co.ndensan.reams.db.dbd.service.core.jukyushokai.JukyuShokaiService;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBDCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.NinteiShienShinseiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.SakujoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 「受給照会」画面のHandlerクラスです。
 *
 * @reamsid_L DBD-3560-010 xuyue
 */
public class JukyushaShokaiHandler {

    private static final RString 履歴番号_0000 = new RString("0000");
    private static final RString 更新申請_内 = new RString("更新申請（内）");
    private static final RString 新規申請_外 = new RString("新規申請（外）");
    private static final RString 新規申請_支援 = new RString("新規申請（支援）");
    private static final RString 区分変更申請 = new RString("区分変更申請");
    private static final RString サービス変更申請 = new RString("サービス変更申請");
    private static final RString 新規申請 = new RString("新規申請");
    private static final RString 特殊変更申請前 = new RString("特殊変更申請前");
    private static final RString 新規認定 = new RString("新規認定");
    private static final RString 更新認定_内 = new RString("更新認定（内）");
    private static final RString 更新認定_外 = new RString("更新認定（外）");
    private static final RString 新規支援認定 = new RString("新規支援認定");
    private static final RString 変更認定 = new RString("変更認定");
    private static final RString サービス変更認定 = new RString("サービス変更認定");
    private static final RString 法施行前認定 = new RString("法施行前認定");
    private static final RString みなし = new RString("（みなし）");
    private static final RString 通常 = new RString("通常");
    private static final RString 職権 = new RString("職権");
    private static final RString 取得 = new RString("取得");
    private static final RString 却下 = new RString("却下");
    private static final RString 申請取消 = new RString("申請取消");
    private static final RString 特殊 = new RString("特殊");
    private static final RString 措 = new RString("措");
    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
    private static final RString KEY3 = new RString("3");

    private final JukyushaShokaiDiv div;
    private final JukyuShokaiService service;

    /**
     * コンストラクタです。
     *
     * @param div 受給照会のコントロールdiv
     */
    public JukyushaShokaiHandler(JukyushaShokaiDiv div) {
        this.div = div;
        service = JukyuShokaiService.createInstance();
    }

    /**
     * 初期化の処理です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return レスポンスデータ
     */
    public ResponseData<JukyushaShokaiDiv> initialize(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {

        div.getKaigoAtena().initialize(識別コード);
        div.getKaigoShikaku().initialize(被保険者番号);

        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        PersonalData personalData = PersonalData.of(識別コード, expandedInfo);
        AccessLogger.log(AccessLogType.照会, personalData);

        RiyoshaFutanWariaiMeisai 利用者負担割合明細 = service.get利用者負担割合(被保険者番号);
        if (利用者負担割合明細.get年度() != null && !利用者負担割合明細.get年度().isEmpty()) {
            div.getTxtRiyoshafutanNendo().setValue(new RDate(利用者負担割合明細.get年度().toDateString().toString()));
        }
        if (利用者負担割合明細.get負担割合区分() != null) {
            div.getTxtRiyoshafutanWariai().setValue(FutanwariaiKubun.toValue(利用者負担割合明細.get負担割合区分()).get名称());
        }
        if (利用者負担割合明細.get有効開始日() != null && !利用者負担割合明細.get有効開始日().isEmpty()) {
            div.getTxtTekiyoKikan().setFromValue(new RDate(利用者負担割合明細.get有効開始日().toString()));
        }
        if (利用者負担割合明細.get有効終了日() != null && !利用者負担割合明細.get有効終了日().isEmpty()) {
            div.getTxtTekiyoKikan().setToValue(new RDate(利用者負担割合明細.get有効終了日().toString()));
        }
        ボタン詳細指示パネルの設定(被保険者番号);

        if (!ResponseHolder.isReRequest()) {
            List<JukyuShokaiShinseiJoho> 申請情報List = service.find申請情報(被保険者番号);
            if (申請情報List.isEmpty()) {
                InformationMessage message = new InformationMessage(DbdInformationMessages.受給照会_履歴なし.getMessage().getCode(),
                        DbdInformationMessages.受給照会_履歴なし.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            一覧情報の編集(申請情報List);
        } else if (new RString(DbdInformationMessages.受給照会_履歴なし.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }

        return ResponseData.of(div).setState(DBD3010002StateName.認定履歴一覧);
    }

    /**
     * 一覧の選択ボタン押下の処理です。
     */
    public void 選択ボタンをクリック() {
        認定詳細パネルのクリア();
        set認定詳細パネル();
    }

    private void 認定詳細パネルのクリア() {
        div.getTxtShinseiDate().clearValue();
        div.getTxtShinseiShubetsu1().clearValue();
        div.getTxtShinseiShubetsu2().clearValue();
        div.getTxtShujiiMeisho().clearValue();

        div.getChkShiteii().setSelectedItemsByKey(null);
        div.getTxtShujiIryokikanMeisho().clearValue();

        div.getChkShinsei().setSelectedItemsByKey(null);
        div.getTxtShinseisha().clearValue();
        div.getTxtShinseiRiyu().clearValue();
        div.getTxtYokaigodoCode().clearValue();
        div.getTxtYokaigodo().clearValue();
        div.getTxtNinteiYMD().clearValue();
        div.getTxtYukoKikan().clearFromValue();
        div.getTxtYukoKikan().clearToValue();

        div.getNinteiDetail().getShiteiServiceIchiran().getDgShiteiServiceShurui().getDataSource().clear();

        div.getNinteiDetail().getNinteichosa().getTxtZenkaiYokaigodo().clearValue();
        div.getNinteiDetail().getNinteichosa().getTxtZenkaiNinteiDate().clearValue();
        div.getNinteiDetail().getNinteichosa().getTxtZenkaiYukokikan().clearFromValue();
        div.getNinteiDetail().getNinteichosa().getTxtZenkaiYukokikan().clearToValue();

        div.getNinteiDetail().getTxtShinsakaiIken().clearValue();
        div.getNinteiDetail().getTxtNinteiResultIdoJiyu().clearValue();
        div.getNinteiDetail().getTxtSakujoJiyu().clearValue();

        div.getNinteiDetail().getTxtRiyu().clearValue();
        div.getNinteiDetail().getTxtTokuteiShippei().clearValue();
        div.getNinteiDetail().getTxtNinteiSoshitsuYMD().clearValue();
        div.getNinteiDetail().getTxtTorikeshiYMD().clearValue();

        div.getNinteiDetail().getNinteiResult().getTxtToshoYukokikan().clearFromValue();
        div.getNinteiDetail().getNinteiResult().getTxtToshoYukokikan().clearToValue();
        div.getNinteiDetail().getNinteiResult().getTxtHakkoDate1().clearValue();
        div.getNinteiDetail().getNinteiResult().getTxtHakkoDate2().clearValue();

        div.getNinteiDetail().getTxtNinteiShinseiKubunShinseiji().clearValue();
        div.getNinteiDetail().getTxtNinteiShinseiKubunHorei().clearValue();
        div.getNinteiDetail().getTxtYukokigen().clearValue();
        div.getNinteiDetail().getTxtKofuDate().clearValue();
    }

    private void 一覧情報の編集(List<JukyuShokaiShinseiJoho> 申請情報List) {

        dgNinteiRireki_Row row;
        RString 履歴番号;
        RString 受給申請事由;
        RString 認定編集値;
        Code 削除事由コード;

        boolean 要支援者認定申請区分;

        List<dgNinteiRireki_Row> dataSource = new ArrayList<>();
        for (JukyuShokaiShinseiJoho joho : 申請情報List) {
            row = new dgNinteiRireki_Row();
            row.getShinseiDate().setValue(joho.get受給者台帳_受給申請年月日());
            row.getNinteiDate().setValue(joho.get受給者台帳_認定年月日());
            row.getKaishiDate().setValue(joho.get受給者台帳_認定有効開始年月日());
            row.getShuryoDate().setValue(joho.get受給者台帳_認定有効終了年月日());
            row.setSo(joho.is受給者台帳_旧措置フラグ() ? 措 : RString.EMPTY);
            row.setShinsakaiIken(joho.get要介護認定インタフェース情報_審査会意見());
            row.setYokaigodo(get要介護度(joho.get受給者台帳_要介護認定状態区分コード()));

            row.setShichosonCode(joho.get受給者台帳_市町村コード().getColumnValue());
            row.setRirekiNo(joho.get受給者台帳_履歴番号());
            row.setEdaban(joho.get受給者台帳_枝番());
            row.setJukyuShinseiJiyu(joho.get受給者台帳_受給申請事由().getColumnValue());

            履歴番号 = joho.get受給者台帳_履歴番号();
            受給申請事由 = joho.get受給者台帳_受給申請事由().getColumnValue();
            要支援者認定申請区分 = joho.is受給者台帳_要支援者認定申請区分();
            if (履歴番号_0000.equals(履歴番号)) {
                if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(受給申請事由)) {
                    認定編集値 = 更新申請_内;
                } else if (JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(受給申請事由)) {
                    認定編集値 = 新規申請_外;
                } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(受給申請事由) && 要支援者認定申請区分) {
                    認定編集値 = 新規申請_支援;
                } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(受給申請事由) && !要支援者認定申請区分) {
                    認定編集値 = 区分変更申請;
                } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(受給申請事由)) {
                    認定編集値 = サービス変更申請;
                } else {
                    認定編集値 = 新規申請;
                }
            } else {
                if (joho.is受給者台帳_論理削除フラグ()) {
                    削除事由コード = joho.get受給者台帳_削除事由コード();
                    if (削除事由コード == null || 削除事由コード.isEmpty() || SakujoJiyuCode.過誤による削除.getコード().
                            equals(SakujoJiyuCode.toValue(削除事由コード.getColumnValue()).getコード())) {
                        認定編集値 = RString.EMPTY;
                    } else {
                        認定編集値 = SakujoJiyuCode.toValue(削除事由コード.getColumnValue()).get名称();
                    }
                } else {
                    認定編集値 = get認定when論理削除isFalse(joho, 受給申請事由, 要支援者認定申請区分);
                }
            }
            row.setNintei(認定編集値);
            dataSource.add(row);
        }
        div.getNinteiRireki().getDgNinteiRireki().setDataSource(dataSource);
    }

    private void ボタン詳細指示パネルの設定(HihokenshaNo 被保険者番号) {
        ServiceJukyuJokyo サービス受給状況 = service.findサービス受給状況(被保険者番号);

        div.getButtonsShosaiShiji().getBtnRiyogenmen().setDisabled(!サービス受給状況.had利用者負担減免());
        div.getButtonsShosaiShiji().getBtnHomonKaigo().setDisabled(!サービス受給状況.had訪問介護減免());
        div.getButtonsShosaiShiji().getBtnShafukuKeigen().setDisabled(!サービス受給状況.had社福軽減());
        div.getButtonsShosaiShiji().getBtnTochiGemmen().setDisabled(!サービス受給状況.had特地減免());
        div.getButtonsShosaiShiji().getBtnFutanGendogaku().setDisabled(!サービス受給状況.had負担限度額認定());
        div.getButtonsShosaiShiji().getBtnHikazeiNenkin().setDisabled(!サービス受給状況.had非課税年金受給());
        div.getButtonsShosaiShiji().getBtnSeikatsuHogo().setDisabled(!サービス受給状況.had生保受給());
        div.getButtonsShosaiShiji().getBtnRoreiFukushi().setDisabled(!サービス受給状況.had老齢受給());
        div.getButtonsShosaiShiji().getBtnIryoHoken().setDisabled(!サービス受給状況.had医療保険加入());
        div.getButtonsShosaiShiji().getBtnShisetsuNyutai().setDisabled(!サービス受給状況.had施設入退所());
        div.getButtonsShosaiShiji().getBtnKyotakuKeikaku().setDisabled(!サービス受給状況.had居宅届出());
        div.getButtonsShosaiShiji().getBtnJigyouTaishosha().setDisabled(!サービス受給状況.hadBeen総合事業対象());
    }

    private RString get認定when論理削除isFalse(JukyuShokaiShinseiJoho joho, RString 受給申請事由, boolean 要支援者認定申請区分) {
        RString データ区分;
        RString みなし要介護区分コード;
        RString みなし文字;
        RString 認定column = RString.EMPTY;
        データ区分 = joho.get受給者台帳_データ区分() == null ? RString.EMPTY : joho.get受給者台帳_データ区分().getColumnValue();
        みなし要介護区分コード = joho.get受給者台帳_みなし要介護区分コード() == null ? RString.EMPTY
                : joho.get受給者台帳_みなし要介護区分コード().getColumnValue();

        if (職権.equals(データ区分種類(データ区分)) || 取得.equals(データ区分種類(データ区分))
                || 却下.equals(データ区分種類(データ区分)) || 申請取消.equals(データ区分種類(データ区分))) {
            認定column = Datakubun.toValue(データ区分).get名称();

        } else if (特殊.equals(データ区分種類(データ区分))) {
            認定column = 特殊変更申請前;
        } else {
            if (MinashiCode.みなし認定_旧措置入所者.getコード().equals(みなし要介護区分コード)) {
                みなし文字 = みなし;
            } else {
                みなし文字 = RString.EMPTY;
            }

            if (JukyuShinseiJiyu.初回申請.getコード().equals(受給申請事由)) {
                認定column = 新規認定;
            } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(受給申請事由)) {
                認定column = 更新認定_内;
            } else if (JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(受給申請事由)) {
                認定column = 更新認定_外;
            } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(受給申請事由) && 要支援者認定申請区分) {
                認定column = 新規支援認定.concat(みなし文字);
            } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(受給申請事由) && !要支援者認定申請区分) {
                認定column = 変更認定.concat(みなし文字);
            } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(受給申請事由)) {
                認定column = サービス変更認定;
            } else if (JukyuShinseiJiyu.申請_法施行前.getコード().equals(受給申請事由)) {
                認定column = 法施行前認定;
            } else {
                認定column = RString.EMPTY;
            }
        }
        return 認定column;
    }

    private void set認定詳細パネル() {
        dgNinteiRireki_Row row = div.getNinteiRireki().getDgNinteiRireki().getActiveRow();

        List<JukyuShokaiShinseiNinteiJoho> 申請認定情報List = service.
                find申請認定情報(row.getShichosonCode(), row.getRirekiNo(), row.getEdaban(), row.getJukyuShinseiJiyu());
        if (申請認定情報List == null || 申請認定情報List.isEmpty()) {
            return;
        }
        JukyuShokaiShinseiNinteiJoho 申請認定情報 = 申請認定情報List.get(0);

        set申請情報パネル(申請認定情報);
        setサービス指定一覧パネル(申請認定情報);
        set前回認定値パネル(申請認定情報);

        div.getNinteiDetail().getTxtShinsakaiIken().setValue(申請認定情報.get要介護認定インターフェース情報_審査会意見());
        if (申請認定情報.get受給者台帳_直近異動事由コード() != null && !申請認定情報.get受給者台帳_直近異動事由コード().isEmpty()) {
            div.getNinteiDetail().getTxtNinteiResultIdoJiyu().setValue(ChokkinIdoJiyuCode.toValue(
                    申請認定情報.get受給者台帳_直近異動事由コード().getColumnValue()).get名称());
        }
        if (申請認定情報.get受給者台帳_削除事由コード() != null && !申請認定情報.get受給者台帳_削除事由コード().isEmpty()) {
            div.getNinteiDetail().getTxtSakujoJiyu().setValue(SakujoJiyuCode.
                    toValue(申請認定情報.get受給者台帳_削除事由コード().getColumnValue()).get名称());
        }

        div.getNinteiDetail().getTxtRiyu().setValue(申請認定情報.受給者台帳_異動理由());
        if (申請認定情報.get受給者台帳_２号特定疾病コード() != null && !申請認定情報.get受給者台帳_２号特定疾病コード().isEmpty()) {
            div.getNinteiDetail().getTxtTokuteiShippei().setValue(TokuteiShippei.toValue(
                    申請認定情報.get受給者台帳_２号特定疾病コード().getColumnValue()).get名称());
        }
        if (申請認定情報.get受給者台帳_喪失年月日() != null) {
            div.getNinteiDetail().getTxtNinteiSoshitsuYMD().setValue(申請認定情報.get受給者台帳_喪失年月日());
        }
        if (get取消日(申請認定情報) != null) {
            div.getNinteiDetail().getTxtTorikeshiYMD().setValue(get取消日(申請認定情報));
        }
        set当初認定パネル(申請認定情報);
        if (申請認定情報.get要介護認定申請情報_認定申請区分申請時コード() != null
                && !申請認定情報.get要介護認定申請情報_認定申請区分申請時コード().isEmpty()) {
            div.getNinteiDetail().getTxtNinteiShinseiKubunShinseiji().setValue(NinteiShinseiShinseijiKubunCode.
                    toValue(申請認定情報.get要介護認定申請情報_認定申請区分申請時コード().getColumnValue()).get名称());
        }
        if (申請認定情報.get要介護認定申請情報_認定申請区分法令コード() != null && !申請認定情報.get要介護認定申請情報_認定申請区分法令コード().isEmpty()) {
            div.getNinteiDetail().getTxtNinteiShinseiKubunHorei().setValue(NinteiShinseiHoreiCode.
                    toValue(申請認定情報.get要介護認定申請情報_認定申請区分法令コード().getColumnValue()).get名称());
        }
        div.getNinteiDetail().getTxtYukokigen().setValue(申請認定情報.get資格者証交付情報_有効期限());
        div.getNinteiDetail().getTxtKofuDate().setValue(申請認定情報.get資格者証交付情報_交付年月日());
    }

    private void set申請情報パネル(JukyuShokaiShinseiNinteiJoho 申請認定情報) {
        div.getTxtShinseiDate().setValue(申請認定情報.get受給者台帳_受給申請年月日());
        if (申請認定情報.get受給者台帳_受給申請事由() != null && !申請認定情報.get受給者台帳_受給申請事由().isEmpty()) {
            div.getTxtShinseiShubetsu1().setValue(JukyuShinseiJiyu.toValue(申請認定情報.get受給者台帳_受給申請事由().getColumnValue()).get名称());
        }
        if (申請認定情報.get受給者台帳_申請書区分() != null && !申請認定情報.get受給者台帳_申請書区分().isEmpty()) {
            div.getTxtShinseiShubetsu2().setValue(NinteiShienShinseiKubun.toValue(申請認定情報.get受給者台帳_申請書区分().getColumnValue()).get名称());
        }
        div.getTxtShujiiMeisho().setValue(申請認定情報.get主治医氏名());

        if (申請認定情報.is指定医フラグ()) {
            List<RString> 指定医keys = new ArrayList<>();
            指定医keys.add(KEY0);
            div.getChkShiteii().setSelectedItemsByKey(指定医keys);
        }
        div.getTxtShujiIryokikanMeisho().setValue(申請認定情報.get医療機関名称());

        List<RString> 申請方法keys = new ArrayList<>();
        if (申請認定情報.is受給者台帳_旧措置者フラグ()) {
            申請方法keys.add(KEY1);
        }
        if (申請認定情報.is受給者台帳_資格取得前申請区分()) {
            申請方法keys.add(KEY2);
        }
        if (申請認定情報.get受給者台帳_みなし要介護区分コード() != null
                && MinashiCode.みなし認定_旧措置入所者.getコード().equals(申請認定情報.get受給者台帳_みなし要介護区分コード().getColumnValue())) {
            申請方法keys.add(KEY3);
        }
        div.getChkShinsei().setSelectedItemsByKey(申請方法keys);
        div.getTxtShinseisha().setValue(申請認定情報.get申請届出情報_申請届出者氏名());
        div.getTxtShinseiRiyu().setValue(申請認定情報.get要介護認定申請情報_認定申請理由());
        div.getTxtYokaigodoCode().setValue(get要介護度コード(申請認定情報.get受給者台帳_要介護認定状態区分コード()));
        div.getTxtYokaigodo().setValue(get要介護度(申請認定情報.get受給者台帳_要介護認定状態区分コード()));
        div.getTxtNinteiYMD().setValue(申請認定情報.get受給者台帳_認定年月日());
        if (申請認定情報.get受給者台帳_当初認定有効期間開始年月日() != null && !申請認定情報.get受給者台帳_当初認定有効期間開始年月日().isEmpty()) {
            div.getTxtYukoKikan().setFromValue(new RDate(申請認定情報.get受給者台帳_当初認定有効期間開始年月日().toString()));
        }
        if (申請認定情報.get受給者台帳_当初認定有効期間終了年月日() != null && !申請認定情報.get受給者台帳_当初認定有効期間終了年月日().isEmpty()) {
            div.getTxtYukoKikan().setToValue(new RDate(申請認定情報.get受給者台帳_当初認定有効期間終了年月日().toString()));
        }
    }

    private void setサービス指定一覧パネル(JukyuShokaiShinseiNinteiJoho 申請認定情報) {
        List<dgShiteiServiceShurui_Row> dataSource = new ArrayList<>();

        set指定サービス種類01To10(申請認定情報, dataSource);
        set指定サービス種類11To20(申請認定情報, dataSource);
        set指定サービス種類21To30(申請認定情報, dataSource);
        div.getNinteiDetail().getShiteiServiceIchiran().getDgShiteiServiceShurui().setDataSource(dataSource);
    }

    private void set指定サービス種類01To10(JukyuShokaiShinseiNinteiJoho 申請認定情報, List<dgShiteiServiceShurui_Row> dataSource) {
        if (申請認定情報.get指定サービス種類01() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類01()));
        }
        if (申請認定情報.get指定サービス種類02() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類02()));
        }
        if (申請認定情報.get指定サービス種類03() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類03()));
        }
        if (申請認定情報.get指定サービス種類04() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類04()));
        }
        if (申請認定情報.get指定サービス種類05() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類05()));
        }
        if (申請認定情報.get指定サービス種類06() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類06()));
        }
        if (申請認定情報.get指定サービス種類07() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類07()));
        }
        if (申請認定情報.get指定サービス種類08() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類08()));
        }
        if (申請認定情報.get指定サービス種類09() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類09()));
        }
        if (申請認定情報.get指定サービス種類10() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類10()));
        }
    }

    private void set指定サービス種類11To20(JukyuShokaiShinseiNinteiJoho 申請認定情報, List<dgShiteiServiceShurui_Row> dataSource) {
        if (申請認定情報.get指定サービス種類11() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類11()));
        }
        if (申請認定情報.get指定サービス種類12() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類12()));
        }
        if (申請認定情報.get指定サービス種類13() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類13()));
        }
        if (申請認定情報.get指定サービス種類14() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類14()));
        }
        if (申請認定情報.get指定サービス種類15() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類15()));
        }
        if (申請認定情報.get指定サービス種類16() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類16()));
        }
        if (申請認定情報.get指定サービス種類17() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類17()));
        }
        if (申請認定情報.get指定サービス種類18() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類18()));
        }
        if (申請認定情報.get指定サービス種類19() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類19()));
        }
        if (申請認定情報.get指定サービス種類20() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類20()));
        }
    }

    private void set指定サービス種類21To30(JukyuShokaiShinseiNinteiJoho 申請認定情報, List<dgShiteiServiceShurui_Row> dataSource) {
        if (申請認定情報.get指定サービス種類21() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類21()));
        }
        if (申請認定情報.get指定サービス種類22() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類22()));
        }
        if (申請認定情報.get指定サービス種類23() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類23()));
        }
        if (申請認定情報.get指定サービス種類24() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類24()));
        }
        if (申請認定情報.get指定サービス種類25() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類25()));
        }
        if (申請認定情報.get指定サービス種類26() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類26()));
        }
        if (申請認定情報.get指定サービス種類27() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類27()));
        }
        if (申請認定情報.get指定サービス種類28() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類28()));
        }
        if (申請認定情報.get指定サービス種類29() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類29()));
        }
        if (申請認定情報.get指定サービス種類30() != null) {
            dataSource.add(get指定サービスRow(申請認定情報.get指定サービス種類30()));
        }
    }

    private dgShiteiServiceShurui_Row get指定サービスRow(ServiceShuruiCode 指定サービス種類) {
        dgShiteiServiceShurui_Row row = new dgShiteiServiceShurui_Row();
        row.getServiceNo().setValue(指定サービス種類.getColumnValue());

        if (CodeMaster.getCode(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.指定サービス種類コード.getコード(), new Code(指定サービス種類.getColumnValue()),
                new FlexibleDate(RDate.getNowDate().toDateString())) != null) {
            row.setServiceType(CodeMaster.
                    getCode(SubGyomuCode.DBD介護受給, DBDCodeShubetsu.指定サービス種類コード.getコード(), new Code(指定サービス種類.getColumnValue()),
                            new FlexibleDate(RDate.getNowDate().toDateString())).getコード略称());
        }
        return row;
    }

    private void set前回認定値パネル(JukyuShokaiShinseiNinteiJoho 申請認定情報) {
        div.getNinteiDetail().getNinteichosa().getTxtZenkaiYokaigodo().setValue(get要介護度(申請認定情報.get前回要介護認定状態区分コード()));
        div.getNinteiDetail().getNinteichosa().getTxtZenkaiNinteiDate().setValue(申請認定情報.get前回認定年月日());
        if (申請認定情報.get前回認定有効期間開始() != null && !申請認定情報.get前回認定有効期間開始().isEmpty()) {
            div.getNinteiDetail().getNinteichosa().getTxtZenkaiYukokikan().setFromValue(new RDate(申請認定情報.get前回認定有効期間開始().toString()));
        }
        if (申請認定情報.get前回認定有効期間終了() != null && !申請認定情報.get前回認定有効期間終了().isEmpty()) {
            div.getNinteiDetail().getNinteichosa().getTxtZenkaiYukokikan().setToValue(new RDate(申請認定情報.get前回認定有効期間終了().toString()));
        }
    }

    private void set当初認定パネル(JukyuShokaiShinseiNinteiJoho 申請認定情報) {
        if (申請認定情報.get受給者台帳_当初認定有効期間開始年月日() != null && !申請認定情報.get受給者台帳_当初認定有効期間開始年月日().isEmpty()) {
            div.getNinteiDetail().getNinteiResult().getTxtToshoYukokikan().
                    setFromValue(new RDate(申請認定情報.get受給者台帳_当初認定有効期間開始年月日().toString()));
        }
        if (申請認定情報.get受給者台帳_当初認定有効期間終了年月日() != null && !申請認定情報.get受給者台帳_当初認定有効期間終了年月日().isEmpty()) {
            div.getNinteiDetail().getNinteiResult().getTxtToshoYukokikan().
                    setToValue(new RDate(申請認定情報.get受給者台帳_当初認定有効期間終了年月日().toString()));
        }
        div.getNinteiDetail().getNinteiResult().getTxtHakkoDate1().setValue(申請認定情報.get受給者台帳_受給資格証明書発行年月日１());
        div.getNinteiDetail().getNinteiResult().getTxtHakkoDate2().setValue(申請認定情報.get受給者台帳_受給資格証明書発行年月日２());
    }

    private RString get要介護度(Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return YokaigoJotaiKubunSupport.toValue(new FlexibleDate(RDate.getNowDate().toDateString()), code.getColumnValue()).getName();
    }

    private RString get要介護度コード(Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return YokaigoJotaiKubunSupport.toValue(new FlexibleDate(RDate.getNowDate().toDateString()), code.getColumnValue()).getCode();
    }

    private FlexibleDate get取消日(JukyuShokaiShinseiNinteiJoho 申請認定情報) {
        RString データ区分 = 申請認定情報.get受給者台帳_データ区分() == null ? RString.EMPTY : 申請認定情報.get受給者台帳_データ区分().getColumnValue();
        if (職権.equals(データ区分種類(データ区分))) {
            return 申請認定情報.get受給者台帳_直近異動年月日();
        }
        return null;
    }

    private RString データ区分種類(RString データ区分) {
        if (Datakubun.通常_認定.getコード().equals(データ区分)) {
            return 通常;
        } else if (is職権(データ区分)) {
            return 職権;
        } else if (is取得(データ区分)) {
            return 取得;
        } else if (is却下(データ区分)) {
            return 却下;
        } else if (is却下申請取消(データ区分)) {
            return 申請取消;
        } else if (Datakubun.開始日同日の区分変更前情報.getコード().equals(データ区分)) {
            return 特殊;
        }
        return RString.EMPTY;
    }

    private boolean is職権(RString データ区分) {
        if (Datakubun.職権による認定取消.getコード().equals(データ区分)
                || Datakubun.審査会結果による認定取消.getコード().equals(データ区分)
                || Datakubun.本人届出_サ利用無による取消.getコード().equals(データ区分)
                || Datakubun.本人届出_その他による取消.getコード().equals(データ区分)
                || Datakubun.要介護度3段階低下による取消.getコード().equals(データ区分)
                || Datakubun.その他の理由による認定取消.getコード().equals(データ区分)) {
            return true;
        }
        return false;
    }

    private boolean is取得(RString データ区分) {
        if (Datakubun.受給者転入.getコード().equals(データ区分)
                || Datakubun.過誤による追加.getコード().equals(データ区分)
                || Datakubun.やむを得ない理由による追加.getコード().equals(データ区分)
                || Datakubun.職権による追加_修正.getコード().equals(データ区分)
                || Datakubun.要介護度3段階低下による追加.getコード().equals(データ区分)
                || Datakubun.その他の理由による追加.getコード().equals(データ区分)) {
            return true;
        }
        return false;
    }

    private boolean is却下(RString データ区分) {
        if (Datakubun.要介護度の変更無しによる却下.getコード().equals(データ区分)
                || Datakubun.自立による却下.getコード().equals(データ区分)
                || Datakubun.訪問調査未実施による却下.getコード().equals(データ区分)
                || Datakubun.意見書未実施による却下.getコード().equals(データ区分)
                || Datakubun.審査会都合による却下.getコード().equals(データ区分)
                || Datakubun.要介護度3段階低下による却下.getコード().equals(データ区分)
                || Datakubun.職権による却下.getコード().equals(データ区分)
                || Datakubun.その他の理由による却下.getコード().equals(データ区分)) {
            return true;
        }
        return false;
    }

    private boolean is却下申請取消(RString データ区分) {
        if (Datakubun.過誤による申請取消.getコード().equals(データ区分)
                || Datakubun.申請による申請取消.getコード().equals(データ区分)
                || Datakubun.転出による申請取消.getコード().equals(データ区分)
                || Datakubun.死亡による申請取消.getコード().equals(データ区分)
                || Datakubun.職権による申請取消.getコード().equals(データ区分)
                || Datakubun.その他の理由による申請取消.getコード().equals(データ区分)) {
            return true;
        }
        return false;
    }

}
