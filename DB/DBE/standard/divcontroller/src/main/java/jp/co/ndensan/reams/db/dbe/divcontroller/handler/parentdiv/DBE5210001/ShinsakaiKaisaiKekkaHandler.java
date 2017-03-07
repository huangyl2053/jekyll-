/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiKaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiWariateIinJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsChikokuUmu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IssotaiUmu;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.OnseiFileOperator.OnseiFileOperator.IOnseiFileOperatorDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.ShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 介護認定審査会開催結果登録するクラスです。
 *
 * @reamsid_L DBE-0160-010 wangxiaodong
 */
public class ShinsakaiKaisaiKekkaHandler {

    private final ShinsakaiKaisaiKekkaDiv div;
    private static final RString BUTTON_UPDATE = new RString("btnUpdate");
    private static final RString 完了メッセージ文言 = new RString("審査会名称：");
    private static final RString 模擬 = new RString("key0");
    private static final RString 精神科医所属 = new RString("key0");
    private static final RString 審査結果 = new RString("審査結果");
    private static final RString 審査結果_模擬 = new RString("模擬");

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催結果登録Div
     */
    public ShinsakaiKaisaiKekkaHandler(ShinsakaiKaisaiKekkaDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアです。
     *
     * @param 音声情報リスト 音声情報リスト
     * @param saiYoteiJoho ヘッドエリア内容
     */
    public void onLoad(List<ShinsakaiKaisaiYoteiJohoBusiness> saiYoteiJoho, List<ShinsakaiOnseiJoho2> 音声情報リスト) {
        List<RString> chkMogiKey = new ArrayList();
        List<RString> shurui = new ArrayList<>();
        chkMogiKey.add(模擬);
        shurui.add(精神科医所属);
        boolean is新規 = false;
        for (int i = 0; i < saiYoteiJoho.size(); i++) {
            ShinsakaiKaisaiYoteiJohoBusiness business = saiYoteiJoho.get(i);
            div.getTxtShinsakaiMeisho().setValue(business.get審査会名称());
            div.setGogitaiNo(new RString(String.valueOf(business.get合議体番号())));
            div.getTxtGogitai().setValue(business.get合議体名称());
            div.getTxtYoteiTeiin().setValue(new Decimal(business.get予定定員()));
            div.getTxtWaritsuke().setValue(new Decimal(business.get予定人数()));
            div.getTxtYoteiKaijo().setValue(business.get介護認定審査会開催場所名称());
            div.getTxtKaisaiYoteibi().setValue(business.get開催予定日());
            div.getTxtYoteiStartTime().setValue(strToTime(business.get予定開始時間()));
            div.getTxtYoteiEndTime().setValue(strToTime(business.get予定終了時間()));
            div.getShinsakaiKaisaiInfo().getTxtShoyoTime().setValue(new Decimal(business.get所要時間()));
            div.getTxtChikuCode().setValue(business.get開催地区コード());
            div.getTxtChikuMeisho().setValue(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DBECodeShubetsu.審査会地区コード.getコード(), new Code(business.get開催地区コード())));
            if (business.is精神科存在フラグ()) {
                div.getChkShurui().setSelectedItemsByKey(shurui);
            }
            if (business.is合議体ダミーフラグ()) {
                div.getChkMogi().setSelectedItemsByKey(chkMogiKey);
                ViewStateHolder.put(ViewStateKeys.利用モード, 審査結果_模擬);
            } else {
                ViewStateHolder.put(ViewStateKeys.利用モード, 審査結果);
            }
            if (business.get介護認定審査会開催番号() != null && !business.get介護認定審査会開催番号().isEmpty()) {
                div.getShinsakaiKaisaiInfo().getTxtKaisaiBi().setValue(business.get開催日());
                div.getShinsakaiKaisaiInfo().getTxtKaisaiStartTime().setValue(strToTime(business.get開催開始時間()));
                div.getShinsakaiKaisaiInfo().getTxtKaisaiEndTime().setValue(strToTime(business.get開催終了時間()));
                div.getShinsakaiKaisaiInfo().getTxtJissiSu().setValue(new Decimal(business.get実施人数()));
                if (business.get開催会場() != null) {
                    div.getShinsakaiKaisaiInfo().getDdlKaisaiBasho().setSelectedKey(business.get開催会場());
                }
            } else {
                is新規 = true;
                div.getShinsakaiKaisaiInfo().getTxtKaisaiBi().setValue(business.get開催予定日());
                div.getShinsakaiKaisaiInfo().getTxtKaisaiStartTime().setValue(strToTime(business.get予定開始時間()));
                div.getShinsakaiKaisaiInfo().getTxtKaisaiEndTime().setValue(strToTime(business.get予定終了時間()));
                div.getShinsakaiKaisaiInfo().getTxtJissiSu().setValue(new Decimal(business.get予定人数()));
                if (business.get介護認定審査会開催予定場所コード() != null) {
                    div.getShinsakaiKaisaiInfo().getDdlKaisaiBasho().setSelectedKey(business.get介護認定審査会開催予定場所コード());
                }
            }
        }
        if (is新規) {
            div.setModel(new RString("新規モード"));
        } else {
            div.setModel(new RString("更新モード"));
        }
        set音声情報(音声情報リスト);
    }

    /**
     * ヘッドエリア内容の状態設定です。
     *
     */
    public void setDisabled() {
        div.getTxtShinsakaiMeisho().setDisabled(true);
        div.getTxtGogitai().setDisabled(true);
        div.getTxtYoteiTeiin().setDisabled(true);
        div.getTxtYoteiKaijo().setDisabled(true);
        div.getTxtKaisaiYoteibi().setDisabled(true);
        div.getTxtYoteiStartTime().setDisabled(true);
        div.getTxtYoteiEndTime().setDisabled(true);
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアです。
     *
     * @param list 審査会委員一覧設定
     *
     */
    public void initialize(List<ShinsakaiWariateIinJohoBusiness> list) {
        List<dgShinsakaiIinIchiran_Row> dataGridList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            dgShinsakaiIinIchiran_Row row = new dgShinsakaiIinIchiran_Row();
            ShinsakaiWariateIinJohoBusiness business = list.get(i);
            row.getNumber().setValue(new Decimal(i + 1));
            row.setShinsakjaiIinCode(business.get審査会委員コード());
            row.setShimei(business.get介護認定審査会委員氏名().value());
            row.setShimei(business.get介護認定審査会委員氏名().value());
            row.setSeibetsu(business.get性別() == null ? RString.EMPTY : Seibetsu.toValue(business.get性別()).get名称());
            row.setShikaku(business.get介護認定審査員資格コード() == null
                    ? RString.EMPTY : Sikaku.toValue(business.get介護認定審査員資格コード().value()).get名称());
            row.setGogitaichoKubun(business.get合議体長区分コード() == null
                    ? RString.EMPTY : GogitaichoKubunCode.toValue(business.get合議体長区分コード().value()).get名称());
            row.getGichoKubun().setDataSource(setKaigoninteiShinsakaiGichoKubunCode());
            row.getGichoKubun().setSelectedKey(business.get介護認定審査会議長区分コード().value());
            row.getShukketsuKubun().setDataSource(setIsShusseki());
            row.getShukketsuKubun().setSelectedKey(new RString(String.valueOf(business.is委員出席())));
            row.getChikokuUmu().setDataSource(setIsChikokuUmu());
            row.getChikokuUmu().setSelectedKey(new RString(String.valueOf(business.is委員遅刻有無())));
            row.getShussekiTime().setValue(strToTime(business.get委員出席時間()));
            row.getSotaiUmu().setDataSource(setIssotaiUmu());
            row.getSotaiUmu().setSelectedKey(new RString(String.valueOf(business.is委員早退有無())));
            row.getTaisekiTime().setValue(strToTime(business.get委員退席時間()));
            dataGridList.add(row);
        }
        div.getDgShinsakaiIinIchiran().setDataSource(dataGridList);
    }

    /**
     * 審査会登録入力不可となるようコントロールの表示制御をします。
     */
    public void set審査会登録入力不可() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BUTTON_UPDATE, Boolean.TRUE);
        div.setDisabled(true);
        div.getIinMiwariate().setDisplayNone(false);
    }

    /**
     * 開催開始時刻を返します。
     *
     * @return 開催開始時刻
     */
    public RTime get開催開始時刻() {
        return div.getShinsakaiKaisaiInfo().getTxtKaisaiStartTime().getValue();
    }

    /**
     * 開催終了時刻を返します。
     *
     * @return 開催終了時刻
     */
    public RTime get開催終了時刻() {
        return div.getShinsakaiKaisaiInfo().getTxtKaisaiEndTime().getValue();
    }

    /**
     * 開催開始時刻と終了時刻から所要時間の分の数を算出します。
     *
     * @return 開催開始時刻と終了時刻から算出された所要時間の分の数
     */
    public long get所要時間from開催期間() {
        RTime 開始時刻 = get開催開始時刻();
        RTime 終了時刻 = get開催終了時刻();
        if (開始時刻 == null || 終了時刻 == null) {
            return 0;
        }
        if (終了時刻.isBefore(開始時刻)) {
            return 0;
        }
        return 開始時刻.minutesDuration(終了時刻);
    }

    /**
     * 渡された所要時間を設定します。
     *
     * @param 所要時間 所要時間
     */
    public void set所要時間(long 所要時間) {
        if (所要時間 == 0) {
            div.getShinsakaiKaisaiInfo().getTxtShoyoTime().clearValue();
        } else {
            div.getShinsakaiKaisaiInfo().getTxtShoyoTime().setValue(new Decimal(所要時間));
        }
    }

    /**
     * 音声情報を追加表示します。
     *
     * @param 音声情報 音声情報
     * @param 追加日時 追加日時
     */
    public void add音声情報(ShinsakaiOnseiJoho2 音声情報, RDateTime 追加日時) {
        IOnseiFileOperatorDiv 音声情報共有子Div = div.getCrOnseiFiles().getNewRepeatControlInstance();
        音声情報共有子Div.initialize(音声情報, 追加日時);
        if (div.getCrOnseiFiles().isDisplayNone()) {
            List<IOnseiFileOperatorDiv> 音声情報共有子DivList = new ArrayList<>();
            音声情報共有子DivList.add(音声情報共有子Div);
            div.getCrOnseiFiles().setRepeateData(音声情報共有子DivList);
            div.getCrOnseiFiles().setDisplayNone(false);
        } else {
            div.getCrOnseiFiles().getRepeateData().add(音声情報共有子Div);
        }
    }

    /**
     * 完了メッセージを設定します。
     *
     * @param 審査会名称 審査会名称
     */
    public void set完了メッセージ(RString 審査会名称) {
        div.getKanryoPanel().getCcdKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                完了メッセージ文言.concat(審査会名称), RString.EMPTY, true);
    }

    /**
     * 審査会名称を取得します。
     *
     * @return 審査会名称 審査会名称
     */
    public RString get審査会名称() {
        return div.getTxtShinsakaiMeisho().getValue();
    }

    private void set音声情報(List<ShinsakaiOnseiJoho2> 音声情報リスト) {
        div.getCrOnseiFiles().setDisplayNone(true);
        if (音声情報リスト == null || 音声情報リスト.isEmpty()) {
            return;
        }
        for (ShinsakaiOnseiJoho2 音声情報 : 音声情報リスト) {
            add音声情報(音声情報, 音声情報.getInsertTimestamp());
        }
    }

    private List<KeyValueDataSource> setKaigoninteiShinsakaiGichoKubunCode() {
        List<KeyValueDataSource> shinsakaiGichoKubunCode = new ArrayList<>();
        for (KaigoninteiShinsakaiGichoKubunCode gichoKubunCode : KaigoninteiShinsakaiGichoKubunCode.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(gichoKubunCode.getコード(), gichoKubunCode.get名称());
            shinsakaiGichoKubunCode.add(dataSource);
        }
        return shinsakaiGichoKubunCode;
    }

    private List<KeyValueDataSource> setIsShusseki() {
        List<KeyValueDataSource> shusseki = new ArrayList<>();
        for (IsShusseki isShusseki : IsShusseki.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(new RString(String.valueOf(isShusseki.is委員出席())), isShusseki.get名称());
            shusseki.add(dataSource);
        }
        return shusseki;
    }

    private List<KeyValueDataSource> setIssotaiUmu() {
        List<KeyValueDataSource> sotaiUmu = new ArrayList<>();
        KeyValueDataSource dataSource = new KeyValueDataSource(new RString(String.valueOf(IssotaiUmu.早退なし.is委員早退())), RString.EMPTY);
        sotaiUmu.add(dataSource);
        KeyValueDataSource dataSource1 = new KeyValueDataSource(new RString(String.valueOf(IssotaiUmu.早退.is委員早退())), IssotaiUmu.早退.get名称());
        sotaiUmu.add(dataSource1);
        return sotaiUmu;
    }

    private List<KeyValueDataSource> setIsChikokuUmu() {
        List<KeyValueDataSource> chikokuUmu = new ArrayList<>();
        KeyValueDataSource dataSource = new KeyValueDataSource(new RString(String.valueOf(IsChikokuUmu.遅刻なし.is委員遅刻())), RString.EMPTY);
        chikokuUmu.add(dataSource);
        KeyValueDataSource dataSource1 = new KeyValueDataSource(new RString(String.valueOf(IsChikokuUmu.遅刻.is委員遅刻())), IsChikokuUmu.遅刻.get名称());
        chikokuUmu.add(dataSource1);
        return chikokuUmu;
    }

    private RTime strToTime(RString str) {
        if (str == null || str.isEmpty()) {
            return RDateTime.MIN.getTime();
        }
        return new RTime(str);
    }
}
