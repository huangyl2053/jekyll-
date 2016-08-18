/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohoichiranhyo.TaishoShuryoYmd;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.ShichosonJouhouResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.ShotokujohoIchiranhyoSakuseiBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1110001.ShotokuJohoIchiranHyoSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1110001.dgShichosonIchiran_Row;
import jp.co.ndensan.reams.db.dbb.service.core.shotokujohoichiranhyo.ShotokuJohoIchiranhyo;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM51003_所得情報一覧表作成Handler
 *
 * @reamsid_L DBB-1650-010 lijunjun
 */
public class ShotokuJohoIchiranHyoSakuseiHandler {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_4 = 4;
    private static final RString ゼロ時ゼロ分ゼロ秒 = new RString("000000");
    private static final int INDEX_処理年度 = 1999;
    private static final RString 抽出対象_INDEX_1 = new RString("1");
    private static final RString 抽出対象_INDEX_2 = new RString("2");
    private static final RString 抽出対象_INDEX_3 = new RString("3");
    private static final RString INDEX_111 = new RString("111");
    private static final RString INDEX_112 = new RString("112");
    private static final RString INDEX_120 = new RString("120");
    private static final RString キー_KEY0 = new RString("key0");
    private static final RString キー_KEY1 = new RString("key1");
    private static final ReportId 帳票ID = new ReportId("DBB200008_KaigoHokenShotokuJohoIchiran");
    private final ShotokuJohoIchiranHyoSakuseiDiv div;

    /**
     * コンストラクタです
     *
     * @param div ShotokuJohoIchiranHyoSakuseiDiv
     */
    public ShotokuJohoIchiranHyoSakuseiHandler(ShotokuJohoIchiranHyoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです
     *
     * @param div ShotokuJohoIchiranHyoSakuseiDiv
     * @return ShotokuJohoIchiranHyoSakuseiHandler
     */
    public ShotokuJohoIchiranHyoSakuseiHandler of(ShotokuJohoIchiranHyoSakuseiDiv div) {
        return new ShotokuJohoIchiranHyoSakuseiHandler(div);
    }

    /**
     * 初期化のメソッドです。
     *
     * @param 導入形態コード RString
     */
    public void initialize(RString 導入形態コード) {
        set処理年度();
        div.getDdlShoriNendo().setSelectedIndex(INDEX_0);
        div.getRadRirekiSelect().setSelectedKey(キー_KEY1);
        ShotokuJohoIchiranhyo ichiranhyo = ShotokuJohoIchiranhyo.createInstance();
        List<KoikiZenShichosonJoho> 広域現市町村リスト = new ArrayList<>();
        FlexibleYear 処理年度 = new FlexibleYear(div.getDdlShoriNendo().getSelectedKey());
        YMDHMS システム日付 = YMDHMS.now();
        if (INDEX_111.equals(導入形態コード)) {
            KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
            広域現市町村リスト = finder.getGenShichosonJoho().records();
            List<TaishoShuryoYmd> 対象終了日時 = ichiranhyo.getTaishoShuryoNichiji(導入形態コード, LasdecCode.EMPTY, 広域現市町村リスト, 処理年度);
            List<dgShichosonIchiran_Row> dgShichosonIchiran = set広域保険者(広域現市町村リスト, 対象終了日時, システム日付, 処理年度);
            div.getDgShichosonIchiran().setDataSource(dgShichosonIchiran);
        } else if (INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) {
            ReamsDonyuDantaiCode 導入団体コード = ControlDataHolder.getReamsDonyuDantaiCode();
            LasdecCode 市町村コード = new LasdecCode(導入団体コード.getColumnValue());
            List<TaishoShuryoYmd> 対象終了日時 = ichiranhyo.getTaishoShuryoNichiji(
                    導入形態コード, 市町村コード, 広域現市町村リスト, 処理年度);
            if (対象終了日時 != null && !対象終了日時.isEmpty()) {
                div.getTxtKakuteiStYMD().setValue(new RDate(new FlexibleDate(対象終了日時.get(INDEX_0).get対象終了日時()
                        .getDate().toString()).wareki().toDateString().toString()));
                div.getTxtKakuteiStTime().setValue(new RTime(対象終了日時.get(INDEX_0).get対象終了日時().getRDateTime()
                        .getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)));
                div.getTxtKakuteiEdYMD().setValue(new RDate(new FlexibleDate(システム日付
                        .getDate().toString()).wareki().toDateString().toString()));
                div.getTxtKakuteiEdTime().setValue(new RTime(システム日付.getRDateTime()
                        .getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)));
            } else {
                div.getTxtKakuteiStYMD().setValue(new RDate(new FlexibleDate(処理年度.getYearValue(),
                        INDEX_4, INDEX_1).wareki().toDateString().toString()));
                div.getTxtKakuteiStTime().setValue(new RTime(new RTime(ゼロ時ゼロ分ゼロ秒)
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)));
                div.getTxtKakuteiEdYMD().setValue(new RDate(new FlexibleDate(システム日付
                        .getDate().toString()).wareki().toDateString().toString()));
                div.getTxtKakuteiEdTime().setValue(new RTime(システム日付.getRDateTime()
                        .getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)));
            }
        }
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBB介護賦課, 帳票ID);
    }

    private List<dgShichosonIchiran_Row> set広域保険者(
            List<KoikiZenShichosonJoho> 広域現市町村リスト,
            List<TaishoShuryoYmd> 対象終了日時,
            YMDHMS システム日付,
            FlexibleYear 処理年度) {
        List<dgShichosonIchiran_Row> dgShichosonIchiran = new ArrayList<>();
        if (対象終了日時 != null && !対象終了日時.isEmpty()) {
            for (KoikiZenShichosonJoho joho : 広域現市町村リスト) {
                for (TaishoShuryoYmd shuryoYmd : 対象終了日時) {
                    if (joho.get市町村コード().equals(shuryoYmd.get市町村コード())) {
                        dgShichosonIchiran_Row row = new dgShichosonIchiran_Row();
                        row.getTxtShichosonCode().setValue(joho.get市町村コード().getColumnValue());
                        row.getTxtShichosonName().setValue(joho.get市町村名称());
                        row.getTxtShichosonShikibetsuID().setValue(joho.get市町村識別ID());
                        row.getTxtShoriStYMD().setValue(new RDate(new FlexibleDate(shuryoYmd.get対象終了日時()
                                .getDate().toString()).wareki().toDateString().toString()));
                        row.getTxtShoriStTime().setValue(new RTime(shuryoYmd.get対象終了日時().getRDateTime()
                                .getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)));
                        row.getTxtShoriEdYMD().setValue(new RDate(new FlexibleDate(システム日付.getDate().toString())
                                .wareki().toDateString().toString()));
                        row.getTxtShoriEdTime().setValue(new RTime(システム日付.getRDateTime().getTime()
                                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)));
                        dgShichosonIchiran.add(row);
                    }
                }
            }
        } else {
            for (KoikiZenShichosonJoho joho : 広域現市町村リスト) {
                dgShichosonIchiran_Row row = new dgShichosonIchiran_Row();
                row.getTxtShichosonCode().setValue(joho.get市町村コード().getColumnValue());
                row.getTxtShichosonName().setValue(joho.get市町村名称());
                row.getTxtShichosonShikibetsuID().setValue(joho.get市町村識別ID());
                row.getTxtShoriStYMD().setValue(new RDate(new FlexibleDate(処理年度.getYearValue(),
                        INDEX_4, INDEX_1).wareki().toDateString().toString()));
                row.getTxtShoriStTime().setValue(new RTime(new RTime(ゼロ時ゼロ分ゼロ秒)
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)));
                row.getTxtShoriEdYMD().setValue(new RDate(new FlexibleDate(システム日付.getDate().toString())
                        .wareki().toDateString().toString()));
                row.getTxtShoriEdTime().setValue(new RTime(システム日付.getRDateTime().getTime()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)));
                dgShichosonIchiran.add(row);
            }
        }
        return dgShichosonIchiran;
    }

    /**
     * 導入形態コードを取得のメソッドです。
     *
     * @return RString
     */
    public RString get導入形態コード() {
        RString 導入形態コード = RString.EMPTY;
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null) {
            導入形態コード = 市町村セキュリティ情報.get導入形態コード().value();
        }
        return 導入形態コード;
    }

    private void set処理年度() {
        RYear 処理年度_調定年度 = new RYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        List<KeyValueDataSource> 処理年度 = new ArrayList<>();
        for (int i = 処理年度_調定年度.getYearValue(); INDEX_処理年度 <= i; i--) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString(String.valueOf(i)));
            dataSource.setValue(new RYear(String.valueOf(i)).wareki().toDateString());
            処理年度.add(dataSource);
        }
        div.getDdlShoriNendo().setDataSource(処理年度);
    }

    /**
     * 抽出対象チェックボックスの変更のメソッドです。
     */
    public void onchange_抽出対象の変更() {
        List<RString> 抽出対象List = div.getChkChushutsuTaisho().getSelectedKeys();
        if (抽出対象List.contains(キー_KEY0) && 抽出対象List.contains(キー_KEY1)) {
            div.getRadRirekiSelect().setSelectedKey(キー_KEY0);
        } else if (抽出対象List.contains(キー_KEY0)) {
            div.getRadRirekiSelect().setSelectedKey(キー_KEY1);
        } else if (抽出対象List.contains(キー_KEY1)) {
            div.getRadRirekiSelect().setSelectedKey(キー_KEY1);
        }
    }

    /**
     * is日付チェックのメソッドです。
     *
     * @return boolean
     */
    public boolean is単一市町村日付チェック() {
        RDate 抽出開始年月日 = div.getTxtKakuteiStYMD().getValue();
        RTime 抽出開始時分秒 = div.getTxtKakuteiStTime().getValue();
        RDate 抽出終了年月日 = div.getTxtKakuteiEdYMD().getValue();
        RTime 抽出終了時分秒 = div.getTxtKakuteiEdTime().getValue();
        YMDHMS 抽出開始 = new YMDHMS(抽出開始年月日, 抽出開始時分秒);
        YMDHMS 抽出終了 = new YMDHMS(抽出終了年月日, 抽出終了時分秒);
        if (抽出終了.isBefore(抽出開始)) {
            return true;
        }
        return false;
    }

    /**
     * is広域保険者日付チェックのメソッドです。
     *
     * @return boolean
     */
    public boolean is広域保険者日付チェック() {
        boolean flag = false;
        List<dgShichosonIchiran_Row> dataList = div.getDgShichosonIchiran().getDataSource();
        for (dgShichosonIchiran_Row row : dataList) {
            RDate 抽出開始年月日 = row.getTxtShoriStYMD().getValue();
            RTime 抽出開始時分秒 = row.getTxtShoriStTime().getValue();
            RDate 抽出終了年月日 = row.getTxtShoriEdYMD().getValue();
            RTime 抽出終了時分秒 = row.getTxtShoriEdTime().getValue();
            YMDHMS 抽出開始 = new YMDHMS(抽出開始年月日, 抽出開始時分秒);
            YMDHMS 抽出終了 = new YMDHMS(抽出終了年月日, 抽出終了時分秒);
            if (抽出終了.isBefore(抽出開始)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 日付のチェックエラーのメソッドです。
     *
     * @param flag boolean
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check日付(boolean flag) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (flag) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.終了日が開始日以前)));
        }
        return validPairs;
    }

    /**
     * BatchParameterを作成のメソッドです。
     *
     * @return ShotokujohoIchiranhyoSakuseiBatchParameter
     */
    public ShotokujohoIchiranhyoSakuseiBatchParameter creatBatchParameter() {
        ShotokujohoIchiranhyoSakuseiBatchParameter parameter = new ShotokujohoIchiranhyoSakuseiBatchParameter();
        RString 導入形態コード = get導入形態コード();
        parameter.set導入形態コード(導入形態コード);
        RYear 処理年度 = new RYear(div.getDdlShoriNendo().getSelectedKey());
        parameter.set処理年度(new FlexibleYear(new RString(処理年度.toString())));
        RString 抽出対象チックボックス = get抽出対象チックボックス();
        RString 抽出対象ラジオボタン = get抽出対象ラジオボタン();
        parameter.setチェックボックス(抽出対象チックボックス);
        parameter.setラジオボタン(抽出対象ラジオボタン);
        if (INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) {
            RDate 抽出開始年月日 = div.getTxtKakuteiStYMD().getValue();
            RTime 抽出開始時分秒 = div.getTxtKakuteiStTime().getValue();
            RDate 抽出終了年月日 = div.getTxtKakuteiEdYMD().getValue();
            RTime 抽出終了時分秒 = div.getTxtKakuteiEdTime().getValue();
            YMDHMS 抽出開始 = new YMDHMS(抽出開始年月日, 抽出開始時分秒);
            YMDHMS 抽出終了 = new YMDHMS(抽出終了年月日, 抽出終了時分秒);
            parameter.set開始日時(抽出開始);
            parameter.set終了日時(抽出終了);
        } else if (INDEX_111.equals(導入形態コード)) {
            RString ログインユーザID = ControlDataHolder.getUserId();
            List<AuthorityItem> authorityItemList = ShichosonSecurityJoho.getShichosonShikibetsuId(ログインユーザID);
            RString 市町村識別ID = authorityItemList.get(INDEX_0).getItemId();
            KoseiShichosonJoho 構成市町村情報 = ShichosonSecurityJoho.getKouseiShichosonJoho(市町村識別ID);
            parameter.set市町村コード(構成市町村情報.get市町村コード());
            parameter.set市町村名称(構成市町村情報.get市町村名称());

            List<dgShichosonIchiran_Row> dataList = div.getDgShichosonIchiran().getDataSource();
            List<ShichosonJouhouResult> 市町村情報List = new ArrayList<>();
            for (dgShichosonIchiran_Row row : dataList) {
                ShichosonJouhouResult result = new ShichosonJouhouResult();
                result.set市町村コード(new LasdecCode(row.getTxtShichosonCode().getValue()));
                result.set市町村識別ID(row.getTxtShichosonShikibetsuID().getValue());
                result.set終了年月日(new FlexibleDate(row.getTxtShoriEdYMD().getValue().toString()));
                result.set終了時刻(new RString(row.getTxtShoriEdTime().getValue().toString()));
                result.set開始年月日(new FlexibleDate(row.getTxtShoriStYMD().getValue().toString()));
                result.set開始時刻(new RString(row.getTxtShoriStTime().getValue().toString()));
                市町村情報List.add(result);
            }
            parameter.set市町村情報リスト(市町村情報List);
        }
        Long 出力順ID = div.getCcdChohyoShutsuryokujun().get出力順ID();
        parameter.set出力順ID(出力順ID);
        return parameter;
    }

    private RString get抽出対象チックボックス() {
        RString 抽出対象チックボックス = RString.EMPTY;
        List<RString> keys = div.getChkChushutsuTaisho().getSelectedKeys();
        if (keys.contains(キー_KEY0) && keys.contains(キー_KEY1)) {
            抽出対象チックボックス = 抽出対象_INDEX_1;
        } else if (keys.contains(キー_KEY0)) {
            抽出対象チックボックス = 抽出対象_INDEX_2;
        } else if (keys.contains(キー_KEY1)) {
            抽出対象チックボックス = 抽出対象_INDEX_3;
        }
        return 抽出対象チックボックス;
    }

    private RString get抽出対象ラジオボタン() {
        RString 抽出対象ラジオボタン = RString.EMPTY;
        RString keys = div.getRadRirekiSelect().getSelectedKey();
        if (キー_KEY0.equals(keys)) {
            抽出対象ラジオボタン = 抽出対象_INDEX_1;
        } else if (キー_KEY1.equals(keys)) {
            抽出対象ラジオボタン = 抽出対象_INDEX_2;
        }
        return 抽出対象ラジオボタン;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
