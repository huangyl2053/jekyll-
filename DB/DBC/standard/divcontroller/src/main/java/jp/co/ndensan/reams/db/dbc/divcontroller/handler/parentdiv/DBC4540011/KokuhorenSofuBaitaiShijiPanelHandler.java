/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4540011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kanri.Baitai;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4540011.KokuhorenSofuBaitaiShijiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4540011.dgKokuhorenSofuBaitaiShiji_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 国保連送付媒体管理のHandlerクラスです。
 *
 * @reamsid_L DBC-3362-010 xuxin
 */
public class KokuhorenSofuBaitaiShijiPanelHandler {

    private static final RString 過誤申立Ｆ = new RString("国保連送付媒体_過誤申立Ｆ");
    private static final RString 給付管理票Ｆ = new RString("国保連送付媒体_給付管理票Ｆ");
    private static final RString 給付実績Ｆ = new RString("国保連送付媒体_給付実績Ｆ");
    private static final RString 共同異動Ｆ = new RString("国保連送付媒体_共同異動Ｆ");
    private static final RString 高額判定Ｆ = new RString("国保連送付媒体_高額判定Ｆ");
    private static final RString 再審申立Ｆ = new RString("国保連送付媒体_再審申立Ｆ");
    private static final RString 受給異動Ｆ = new RString("国保連送付媒体_受給異動Ｆ");
    private static final RString 受給突合Ｆ = new RString("国保連送付媒体_受給突合Ｆ");
    private static final RString 償還Ｆ = new RString("国保連送付媒体_償還Ｆ");
    private static final RString 支給申請Ｆ = new RString("国保連送付媒体_支給申請Ｆ");
    private static final RString 補正自己負担Ｆ = new RString("国保連送付媒体_補正自己負担Ｆ");
    private static final RString 計算結果連絡Ｆ = new RString("国保連送付媒体_計算結果連絡Ｆ");
    private static final RString 合算給付実績Ｆ = new RString("国保連送付媒体_合算給付実績Ｆ");
    private static final RString 過誤申立総合Ｆ = new RString("国保連送付媒体_過誤申立総合Ｆ");
    private static final RString 受給訂正Ｆ = new RString("国保連送付媒体_受給訂正Ｆ");

    private static final RString 媒体 = new RString("_媒体区分");
    private static final RString 外部ＣＳＶ = new RString("_外部ＣＳＶファイル名");
    private static final RString 更新 = new RString("を使用して更新");
    private static final RString 拡張名 = new RString(".CSV");

    private static final int INT_4 = 4;

    private final KokuhorenSofuBaitaiShijiPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 国保連送付媒体管理
     */
    public KokuhorenSofuBaitaiShijiPanelHandler(KokuhorenSofuBaitaiShijiPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期登録状態です。
     */
    public void 初期登録状態() {
        div.getBtnJikko().setDisabled(true);
        div.getBtnTorikeshi().setDisabled(true);
        div.getTxtFileNm().setDisabled(true);
        div.getDdlBaitai().setDisabled(true);
        div.getTxtGaibuCSVFileNm().setDisabled(true);
    }

    /**
     * 国保連送付媒体指示一覧Gridの「選択」ボタン押下時の状態です。
     */
    public void 選択状態() {
        div.getBtnJikko().setDisabled(false);
        div.getBtnTorikeshi().setDisabled(false);
        div.getTxtFileNm().setDisabled(true);
        div.getDdlBaitai().setDisabled(false);
        div.getTxtGaibuCSVFileNm().setDisabled(false);
    }

    /**
     * 画面ロード時の動作です。
     */
    public void initialize() {
        init一覧Grid();
        init媒体DDL();
    }

    private void init媒体DDL() {
        div.getDdlBaitai().getDataSource().clear();
        List<KeyValueDataSource> dataSource媒体 = new ArrayList<>();
        for (Baitai item : Baitai.values()) {
            dataSource媒体.add(new KeyValueDataSource(item.getコード(), item.get名称()));
        }
        div.getDdlBaitai().setDataSource(dataSource媒体);
    }

    private void init一覧Grid() {
        List<dgKokuhorenSofuBaitaiShiji_Row> dataSource = new ArrayList<>();
        RDate 適用基準日 = RDate.getNowDate();
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_過誤申立Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_過誤申立Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_過誤申立Ｆ_外部ＣＳＶファイル名, 過誤申立Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_給付管理票Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_給付管理票Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_給付管理票Ｆ_外部ＣＳＶファイル名, 給付管理票Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_給付実績Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_給付実績Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_給付実績Ｆ_外部ＣＳＶファイル名, 給付実績Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_共同異動Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_共同異動Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_共同異動Ｆ_外部ＣＳＶファイル名, 共同異動Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_高額判定Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_高額判定Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_高額判定Ｆ_外部ＣＳＶファイル名, 高額判定Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_再審申立Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_再審申立Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_再審申立Ｆ_外部ＣＳＶファイル名, 再審申立Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_受給異動Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_受給異動Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_受給異動Ｆ_外部ＣＳＶファイル名, 受給異動Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_受給突合Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_受給突合Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_受給突合Ｆ_外部ＣＳＶファイル名, 受給突合Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_償還Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_償還Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_償還Ｆ_外部ＣＳＶファイル名, 償還Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_支給申請Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_支給申請Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_支給申請Ｆ_外部ＣＳＶファイル名, 支給申請Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_補正自己負担Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_補正自己負担Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_補正自己負担Ｆ_外部ＣＳＶファイル名, 補正自己負担Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_計算結果連絡Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_計算結果連絡Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_計算結果連絡Ｆ_外部ＣＳＶファイル名, 計算結果連絡Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_合算給付実績Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_合算給付実績Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_合算給付実績Ｆ_外部ＣＳＶファイル名, 合算給付実績Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_過誤申立総合Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_過誤申立総合Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_過誤申立総合Ｆ_外部ＣＳＶファイル名, 過誤申立総合Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_受給訂正Ｆ_ファイル名称,
                ConfigNameDBC.国保連送付媒体_受給訂正Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_受給訂正Ｆ_外部ＣＳＶファイル名, 受給訂正Ｆ, 適用基準日));
        div.getDgKokuhorenSofuBaitaiShiji().setDataSource(dataSource);
    }

    private dgKokuhorenSofuBaitaiShiji_Row setRow値(Enum key0, Enum key1, Enum key2, RString key3, RDate 適用基準日) {
        dgKokuhorenSofuBaitaiShiji_Row row = new dgKokuhorenSofuBaitaiShiji_Row();
        row.setDefaultDataName0(getConfig値(key0, 適用基準日));
        if (Baitai.伝送.getコード().equals(getConfig値(key1, 適用基準日))) {
            row.setDefaultDataName1(Baitai.伝送.get名称());
        }
        if (Baitai.ＭＯ.getコード().equals(getConfig値(key1, 適用基準日))) {
            row.setDefaultDataName1(Baitai.ＭＯ.get名称());
        }
        if (Baitai.ＦＤ.getコード().equals(getConfig値(key1, 適用基準日))) {
            row.setDefaultDataName1(Baitai.ＦＤ.get名称());
        }
        if (Baitai.帳票.getコード().equals(getConfig値(key1, 適用基準日))) {
            row.setDefaultDataName1(Baitai.帳票.get名称());
        }
        row.setDefaultDataName2(getConfig値(key2, 適用基準日));
        row.setDefaultDataName3(key3);
        return row;
    }

    private RString getConfig値(Enum key, RDate 適用基準日) {
        return DbBusinessConfig.get(key, 適用基準日, SubGyomuCode.DBC介護給付);
    }

    /**
     * 修正の業務コンフィグを全部保存します。
     */
    public void config保存() {

        RString 保存のconfig名;
        RString 保存のconfig値;
        RString 変更理由 = ResponseHolder.getMenuID().concat(更新);
        RDate 適用基準日 = RDate.getNowDate();
        List<dgKokuhorenSofuBaitaiShiji_Row> dataSource = div.getDgKokuhorenSofuBaitaiShiji().getDataSource();
        for (dgKokuhorenSofuBaitaiShiji_Row row : dataSource) {
            if (RowState.Modified.equals(row.getRowState())) {
                保存のconfig名 = row.getDefaultDataName3().concat(媒体);
                保存のconfig値 = get媒体コード(row.getDefaultDataName1());
                BusinessConfig.update(SubGyomuCode.DBC介護給付, ConfigNameDBC.valueOf(保存のconfig名.toString()),
                        保存のconfig値, 変更理由, RString.EMPTY, 適用基準日);
                保存のconfig名 = row.getDefaultDataName3().concat(外部ＣＳＶ);
                保存のconfig値 = row.getDefaultDataName2();
                BusinessConfig.update(SubGyomuCode.DBC介護給付, ConfigNameDBC.valueOf(保存のconfig名.toString()),
                        保存のconfig値, 変更理由, RString.EMPTY, 適用基準日);
            }
        }
    }

    private RString get媒体コード(RString 媒体名称) {
        if (Baitai.伝送.get名称().equals(媒体名称)) {
            return Baitai.伝送.getコード();
        } else if (Baitai.ＭＯ.get名称().equals(媒体名称)) {
            return Baitai.ＭＯ.getコード();
        } else if (Baitai.ＦＤ.get名称().equals(媒体名称)) {
            return Baitai.ＦＤ.getコード();
        } else {
            return Baitai.帳票.getコード();
        }
    }

    /**
     * 国保連送付媒体指示一覧Gridの「選択」ボタン押下場合の処理です。
     */
    public void 選択ボタン押下時() {
        init媒体DDL();
        dgKokuhorenSofuBaitaiShiji_Row row = div.getDgKokuhorenSofuBaitaiShiji().getClickedItem();
        div.getTxtFileNm().setValue(row.getDefaultDataName0());
        div.getDdlBaitai().setSelectedValue(row.getDefaultDataName1());
        div.getTxtGaibuCSVFileNm().setValue(除去後四位(row.getDefaultDataName2()));
    }

    private RString 除去後四位(RString 外部ファイル名) {
        return 外部ファイル名.substring(0, 外部ファイル名.length() - INT_4);
    }

    /**
     * 編集エリア：ファイル名称、媒体、外部ファイル名の項目値を破棄します。
     */
    public void set入力値破棄() {
        div.getTxtFileNm().clearValue();
        set媒体DDL空白表示();
        div.getTxtGaibuCSVFileNm().clearValue();
    }

    private void set媒体DDL空白表示() {
        div.getDdlBaitai().getDataSource().clear();
        List<KeyValueDataSource> dataSource空白 = new ArrayList<>();
        dataSource空白.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        div.getDdlBaitai().setDataSource(dataSource空白);
        div.getDdlBaitai().setSelectedKey(RString.EMPTY);
    }

    /**
     * 保存操作前の処理(編集エリア入力内容を反映国保連取込媒体指示一覧Gridの選択行 )です。
     */
    public void set入力内容反映() {
        List<dgKokuhorenSofuBaitaiShiji_Row> dataSource = div.getDgKokuhorenSofuBaitaiShiji().getDataSource();
        dgKokuhorenSofuBaitaiShiji_Row row = div.getDgKokuhorenSofuBaitaiShiji().getClickedItem();
        row.setDefaultDataName1(div.getDdlBaitai().getSelectedValue());
        row.setDefaultDataName2(div.getTxtGaibuCSVFileNm().getValue().concat(拡張名));
        row.setRowState(RowState.Modified);
        div.getDgKokuhorenSofuBaitaiShiji().setDataSource(dataSource);
    }

}
