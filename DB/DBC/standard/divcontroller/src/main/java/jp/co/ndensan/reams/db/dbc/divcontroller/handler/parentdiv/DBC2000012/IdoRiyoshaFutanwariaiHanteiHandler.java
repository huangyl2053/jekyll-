/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180020.DBC180020_IdoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000012.IdoRiyoshaFutanwariaiHanteiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * IdoRiyoshaFutanwariaiHanteiHandler_異動分利用者負担割合判定のHandlerクラスです。
 *
 * @reamsid_L DBC-4950-010 liuxiaoyu
 */
public class IdoRiyoshaFutanwariaiHanteiHandler {

    private final IdoRiyoshaFutanwariaiHanteiDiv div;
    private static final int ななしち月 = 7;
    private static final int いち年 = 1;
    private static final int 抽出回数_1 = 1;
    private static final RString 処理区分_異動 = new RString("2");
    private static final int INDEX_処理年度 = 0;
    private static final RString 今回終了日時 = new RString("今回終了日時");
    private static final RString 今回開始日時 = new RString("今回開始日時");
    private static final RString 画面起動時の今回終了日時 = new RString("画面起動時の今回終了日時");
    private static final RString 年次処理実施日時 = new RString("年次処理実施日時");
    private static final RString 実行する = new RString("btnBatchRegister");
    private static final RString KEY0 = new RString("key0");
    private static final RString ERRORFLAG_ERROR = new RString("1");
    private static final RString ERRORFLAG_RIGHT = new RString("0");
    private static final ShoriDateKanriManager MANAGER
            = InstanceProvider.create(ShoriDateKanriManager.class);

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public IdoRiyoshaFutanwariaiHanteiHandler(IdoRiyoshaFutanwariaiHanteiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     *
     * @return IdoRiyoshaFutanwariaiHanteiHandler
     */
    public static IdoRiyoshaFutanwariaiHanteiHandler of(IdoRiyoshaFutanwariaiHanteiDiv div) {
        return new IdoRiyoshaFutanwariaiHanteiHandler(div);
    }

    /**
     * 画面の初期化です。
     *
     * @return RDateTime
     */
    public RDateTime onLoad() {
        List<KeyValueDataSource> list = new ArrayList<>();
        FlexibleDate 現在時刻 = new FlexibleDate(RDate.getNowDate().toDateString());
        FlexibleYear 現在年度 = 現在時刻.getNendo();
        int 現在月 = 現在時刻.getMonthValue();
        FlexibleYear 処理年度;
        if (ななしち月 < 現在月) {
            処理年度 = 現在年度;
        } else {
            処理年度 = 現在年度.minusYear(いち年);
        }
        ShoriDateKanri shoriDateKanri = MANAGER.get年次の最新実施年度();
        FlexibleYear 年次判定年度 = null;
        if (shoriDateKanri != null) {
            年次判定年度 = shoriDateKanri.get年度();
        }
        if (年次判定年度 == null || 年次判定年度.isEmpty()) {
            div.setErrorFlag(DataPassingConverter.serialize(ERRORFLAG_ERROR));
            return null;
        }
        if (処理年度.isBefore(年次判定年度)) {
            KeyValueDataSource keyValueData1 = new KeyValueDataSource(
                    処理年度.toDateString(), 処理年度.wareki().toDateString());
            list.add(keyValueData1);
            KeyValueDataSource keyValueData2 = new KeyValueDataSource(
                    年次判定年度.toDateString(), 年次判定年度.wareki().toDateString());
            list.add(keyValueData2);
        } else if (処理年度.equals(年次判定年度)) {
            KeyValueDataSource keyValueData = new KeyValueDataSource(
                    処理年度.toDateString(), 処理年度.wareki().toDateString());
            list.add(keyValueData);
        } else {
            div.setErrorFlag(DataPassingConverter.serialize(ERRORFLAG_ERROR));
            return null;
        }
        div.getDdlNendo().setDataSource(list);
        div.getDdlNendo().setSelectedIndex(INDEX_処理年度);
        onChange();
        if (null == div.getTxtKonkaiShuryoDate().getValue()) {
            return null;
        }
        return RDateTime.convertFrom(div.getTxtKonkaiShuryoDate().getValue(), div.getTxtKonkaiShuryoTime().getValue());
    }

    /**
     * 年度の変更処理です。
     */
    public void onChange() {
        div.setErrorFlag(DataPassingConverter.serialize(ERRORFLAG_RIGHT));
        ShoriDateKanri 年次処理実施日時ShoriDateKanri = MANAGER
                .get年次の実施日時(new FlexibleYear(div.getDdlNendo().getSelectedKey()));
        if (年次処理実施日時ShoriDateKanri == null
                || 年次処理実施日時ShoriDateKanri.get基準日時() == null
                || 年次処理実施日時ShoriDateKanri.get基準日時().isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する, true);
            div.setErrorFlag(DataPassingConverter.serialize(ERRORFLAG_ERROR));
            return;
        }
        RDateTime 年次処理日時 = 年次処理実施日時ShoriDateKanri.get基準日時().getRDateTime();
        div.getTxtNenjiShoriDate().setValue(年次処理日時.getDate());
        div.getTxtNenjiShoriTime().setValue(年次処理日時.getTime());
        ShoriDateKanri 異動分処理実施日時ShoriDateKanri = MANAGER
                .get異動の実施日時(new FlexibleYear(div.getDdlNendo().getSelectedKey()));
        if (異動分処理実施日時ShoriDateKanri != null) {
            YMDHMS 異動分対象開始日時 = 異動分処理実施日時ShoriDateKanri.get対象開始日時();
            if (null != 異動分対象開始日時) {
                RDateTime 対象開始日時 = 異動分対象開始日時.getRDateTime();
                div.getTxtZenkaiKaishiDate().setValue(対象開始日時.getDate());
                div.getTxtZenkaiKaishiTime().setValue(対象開始日時.getTime());
            }
            YMDHMS 異動分対象終了日時 = 異動分処理実施日時ShoriDateKanri.get対象終了日時();
            if (null != 異動分対象終了日時) {
                RDateTime 対象終了日時 = 異動分対象終了日時.getRDateTime();
                div.getTxtZenkaiShuryoDate().setValue(対象終了日時.getDate());
                div.getTxtZenkaiShuryoTime().setValue(対象終了日時.getTime());
            }
        }
        if (異動分処理実施日時ShoriDateKanri == null) {
            div.getTxtZenkaiKaishiDate().setValue(null);
            div.getTxtZenkaiKaishiTime().setValue(null);
            div.getTxtZenkaiShuryoDate().setValue(div.getTxtNenjiShoriDate().getValue());
            div.getTxtZenkaiShuryoTime().setValue(div.getTxtNenjiShoriTime().getValue());
        }

        div.getTxtKonkaiKaishiDate().setValue(div.getTxtZenkaiShuryoDate().getValue());
        div.getTxtKonkaiKaishiTime().setValue(div.getTxtZenkaiShuryoTime().getValue());
        div.getTxtKonkaiShuryoDate().setValue(RDate.getNowDate());
        div.getTxtKonkaiShuryoTime().setValue(RDate.getNowTime());

    }

    /**
     * 「実行する」ボタンを押下します。
     *
     * @param 画面起動時_今回終了時間 RDateTime
     */
    public void 入力チェック(RDateTime 画面起動時_今回終了時間) {
        RDate 前回_終了年月日 = div.getTxtZenkaiShuryoDate().getValue();
        RTime 前回_終了時分秒 = div.getTxtZenkaiShuryoTime().getValue();
        RDate 今回_開始年月日 = div.getTxtKonkaiKaishiDate().getValue();
        RTime 今回_開始時分秒 = div.getTxtKonkaiKaishiTime().getValue();
        RDate 今回_終了年月日 = div.getTxtKonkaiShuryoDate().getValue();
        RTime 今回_終了時分秒 = div.getTxtKonkaiShuryoTime().getValue();
        RDate 年次処理実施年月日 = div.getTxtNenjiShoriDate().getValue();
        RTime 年次処理実施時刻 = div.getTxtNenjiShoriTime().getValue();
        RDateTime 前回終了時間 = RDateTime.convertFrom(前回_終了年月日, 前回_終了時分秒);
        RDateTime 今回開始時間 = RDateTime.convertFrom(今回_開始年月日, 今回_開始時分秒);
        RDateTime 今回終了時間 = RDateTime.convertFrom(今回_終了年月日, 今回_終了時分秒);
        if (前回終了時間.isBefore(今回開始時間)) {
            throw new ApplicationException(DbcErrorMessages.負担割合判定_未抽出期間エラー.getMessage());
        }
        if (今回開始時間.isBefore(RDateTime.convertFrom(年次処理実施年月日, 年次処理実施時刻))) {
            throw new ApplicationException(DbzErrorMessages.期間が不正_過去日付不可.getMessage()
                    .replace(今回開始日時.toString(), 年次処理実施日時.toString()));
        }
        if (今回_終了年月日 != null && 今回_終了時分秒 != null && 今回開始時間.isAfter(今回終了時間)) {
            throw new ApplicationException(UrErrorMessages.終了日が開始日以前.getMessage());
        }
        if (画面起動時_今回終了時間.isBefore(今回終了時間)) {
            throw new ApplicationException(DbzErrorMessages.期間が不正_未来日付不可.getMessage()
                    .replace(今回終了日時.toString(), 画面起動時の今回終了日時.toString()));
        }
    }

    /**
     * 「はい」を選択した場合、バッチパラメータを設定しバッチを起動する。
     *
     * @return DBC180020_IdoRiyoshaFutanwariaiHanteiParameter
     */
    public DBC180020_IdoRiyoshaFutanwariaiHanteiParameter バッチ起動処理() {
        DBC180020_IdoRiyoshaFutanwariaiHanteiParameter parameter = new DBC180020_IdoRiyoshaFutanwariaiHanteiParameter();
        FlexibleYear 画面_年度 = new FlexibleYear(div.getDdlNendo().getSelectedKey());
        RString 月日 = DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        parameter.setTaishoNendo(画面_年度);
        parameter.setKijunbi(new FlexibleDate(div.getTxtKonkaiShuryoDate().getValue().toDateString()));
        parameter.setShoriKubun(処理区分_異動);
        if (div.getTxtKonkaiKaishiDate().getValue() != null && div.getTxtKonkaiKaishiTime().getValue() != null) {
            parameter.setChushutsuKaishiNichiji(
                    RDateTime.convertFrom(
                            div.getTxtKonkaiKaishiDate().getValue(),
                            div.getTxtKonkaiKaishiTime().getValue()));
        }
        if (div.getTxtKonkaiShuryoDate().getValue() != null && div.getTxtKonkaiShuryoTime().getValue() != null) {
            parameter.setChushutsuShuryonichiNichiji(
                    RDateTime.convertFrom(
                            div.getTxtKonkaiShuryoDate().getValue(),
                            div.getTxtKonkaiShuryoTime().getValue()));
        }
        parameter.setTestMode(div.getChkTest().getSelectedKeys().contains(KEY0));
        parameter.setNendoShuryoNengappi(new FlexibleDate(画面_年度.plusYear(いち年).toString() + 月日.toString()));
        parameter.setShoriNichiji(RDateTime.now());
        parameter.setChushutuKaisu(抽出回数_1);
        return parameter;
    }
}
