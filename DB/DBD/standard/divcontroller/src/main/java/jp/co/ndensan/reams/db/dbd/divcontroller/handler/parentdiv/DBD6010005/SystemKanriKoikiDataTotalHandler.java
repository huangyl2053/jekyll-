/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010005;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.KoikiNinteiShienSystemChosaJisshibiDefault;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.KoikiNinteiShienSystemShinseishaSortOrder;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010005.SystemKanriKoikiDataDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010005.SystemKanriKoikiDataTotalDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * システム管理登録（広域データ交換）画面のHandlerです。
 *
 * @reamsid_L DBD-3764-010 tz_chengpeng
 */
public class SystemKanriKoikiDataTotalHandler {

    private final SystemKanriKoikiDataDiv 広域データ交換パネル;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriKoikiDataTotalDiv
     */
    public SystemKanriKoikiDataTotalHandler(SystemKanriKoikiDataTotalDiv div) {
        this.広域データ交換パネル = div.getSystemKanri().getSystemKanriKoikiData();
    }

    /**
     * 画面初期化
     */
    public void initialize() {
        setDDL項目();
        set初期化ファイル();
    }

    /**
     * DDL項目の設定
     */
    private void setDDL項目() {
        List<KeyValueDataSource> 並び順初期値データソース = new ArrayList<>();
        for (KoikiNinteiShienSystemShinseishaSortOrder 並び順初期値 : KoikiNinteiShienSystemShinseishaSortOrder.values()) {
            並び順初期値データソース.add(new KeyValueDataSource(並び順初期値.getコード(), 並び順初期値.get名称()));
        }
        広域データ交換パネル.getDdlChosainSchedule().setDataSource(並び順初期値データソース);

        List<KeyValueDataSource> 調査実施日初期値データソース = new ArrayList<>();
        for (KoikiNinteiShienSystemChosaJisshibiDefault 調査実施日初期値 : KoikiNinteiShienSystemChosaJisshibiDefault.values()) {
            調査実施日初期値データソース.add(new KeyValueDataSource(調査実施日初期値.getコード(), 調査実施日初期値.get名称()));
        }
        広域データ交換パネル.getDdlHomonChosa().setDataSource(調査実施日初期値データソース);
    }

    /**
     * 画面初期値の設定
     */
    private void set初期化ファイル() {
        RDate 日期 = RDate.getNowDate();

        広域データ交換パネル.getRadNinteiYukoShuryobi()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_認定有効終了日抽出, 日期, SubGyomuCode.DBD介護受給));
        広域データ交換パネル.getDdlChosainSchedule()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_申請者並び順, 日期, SubGyomuCode.DBD介護受給));
        広域データ交換パネル.getDdlHomonChosa()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_調査実施日初期値, 日期, SubGyomuCode.DBD介護受給));
        広域データ交換パネル.getRadIkenshoShinsei()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_意見書申請照会有無, 日期, SubGyomuCode.DBD介護受給));
        広域データ交換パネル.getTxtIchijiHanteiFileName()
                .setValue(DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_一次判定Ｆ名, 日期, SubGyomuCode.DBD介護受給));
        広域データ交換パネル.getTxtHomonChosaFileName().
                setValue(DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_訪問調査Ｆ名, 日期, SubGyomuCode.DBD介護受給));
        広域データ交換パネル.getTxtTokkiJikoFileName().
                setValue(DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_特記事項Ｆ名, 日期, SubGyomuCode.DBD介護受給));
        広域データ交換パネル.getTxtIkenshoFile().
                setValue(DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_意見書Ｆ名, 日期, SubGyomuCode.DBD介護受給));
        広域データ交換パネル.getTxtNichiiIkenshoFile().
                setValue(DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_日医意見書Ｆ名, 日期, SubGyomuCode.DBD介護受給));
        広域データ交換パネル.getTxtShiboJohoFile().
                setValue(DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_資格喪失Ｆ名, 日期, SubGyomuCode.DBD介護受給));
    }

    /**
     * 画面項目保存
     */
    public void save画面項目() {
        RDate 日期 = RDate.getNowDate();

        BusinessConfig.update(ConfigNameDBD.広域認定支援システム_認定有効終了日抽出,
                広域データ交換パネル.getRadNinteiYukoShuryobi().getSelectedKey(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.広域認定支援システム_申請者並び順,
                広域データ交換パネル.getDdlChosainSchedule().getSelectedKey(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.広域認定支援システム_調査実施日初期値,
                広域データ交換パネル.getDdlHomonChosa().getSelectedKey(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.広域認定支援システム_意見書申請照会有無,
                広域データ交換パネル.getRadIkenshoShinsei().getSelectedKey(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.広域認定支援システム_一次判定Ｆ名,
                広域データ交換パネル.getTxtIchijiHanteiFileName().getValue(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.広域認定支援システム_訪問調査Ｆ名,
                広域データ交換パネル.getTxtHomonChosaFileName().getValue(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.広域認定支援システム_特記事項Ｆ名,
                広域データ交換パネル.getTxtTokkiJikoFileName().getValue(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.広域認定支援システム_意見書Ｆ名,
                広域データ交換パネル.getTxtIkenshoFile().getValue(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.広域認定支援システム_日医意見書Ｆ名,
                広域データ交換パネル.getTxtNichiiIkenshoFile().getValue(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.広域認定支援システム_資格喪失Ｆ名,
                広域データ交換パネル.getTxtShiboJohoFile().getValue(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);

    }

    private static final RString 変更理由 = new RString("を使用して更新");
}
