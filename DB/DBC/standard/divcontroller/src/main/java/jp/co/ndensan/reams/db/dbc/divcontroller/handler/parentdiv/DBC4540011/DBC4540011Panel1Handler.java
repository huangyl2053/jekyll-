/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4540011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4540011.DBC4540011Panel1Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4540011.DataGrid1_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 国保連送付媒体管理のHandlerクラスです。
 *
 * @reamsid_L DBC-3362-010 xuxin
 */
public class DBC4540011Panel1Handler {

    private final DBC4540011Panel1Div div;

    private static final RString 媒体コンフィグ値1 = new RString("1");
    private static final RString 媒体コンフィグ値2 = new RString("2");
    private static final RString 媒体コンフィグ値4 = new RString("4");
    private static final RString 媒体コンフィグ値5 = new RString("5");
    private static final RString 媒体文言1 = new RString("1:伝送");
    private static final RString 媒体文言2 = new RString("2:ＭＯ");
    private static final RString 媒体文言4 = new RString("4:ＦＤ");
    private static final RString 媒体文言5 = new RString("5:帳票");

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

    private static final RString 名称 = new RString("_ファイル名称");
    private static final RString 媒体 = new RString("_媒体区分");
    private static final RString 外部ＣＳＶ = new RString("_外部ＣＳＶファイル名");
    private static final RString 更新 = new RString("を使用して更新");

    /**
     * コンストラクタです。
     *
     * @param div 国保連送付媒体管理
     */
    public DBC4540011Panel1Handler(DBC4540011Panel1Div div) {
        this.div = div;
    }

    /**
     * 画面の初期登録状態です。
     */
    public void 初期登録状態() {
        div.getButton1().setDisabled(true);
        div.getButton2().setDisabled(true);
        div.getTextBox1().setDisabled(true);
        div.getTextBox2().setDisabled(true);
        div.getTextBox3().setDisabled(true);
    }

    /**
     * 国保連送付媒体指示一覧Gridの「選択」ボタン押下時の状態です。
     */
    public void 選択状態() {
        div.getButton1().setDisabled(false);
        div.getButton2().setDisabled(false);
        div.getTextBox1().setDisabled(true);
        div.getTextBox2().setDisabled(false);
        div.getTextBox3().setDisabled(false);
    }

    /**
     * 画面ロード時の動作です。
     */
    public void initialize() {

        List<DataGrid1_Row> dataSource = new ArrayList<>();
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_過誤申立Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_過誤申立Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_過誤申立Ｆ_外部ＣＳＶファイル名, 過誤申立Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_給付管理票Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_給付管理票Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_給付管理票Ｆ_外部ＣＳＶファイル名, 給付管理票Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_給付実績Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_給付実績Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_給付実績Ｆ_外部ＣＳＶファイル名, 給付実績Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_共同異動Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_共同異動Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_共同異動Ｆ_外部ＣＳＶファイル名, 共同異動Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_高額判定Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_高額判定Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_高額判定Ｆ_外部ＣＳＶファイル名, 高額判定Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_再審申立Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_再審申立Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_再審申立Ｆ_外部ＣＳＶファイル名, 再審申立Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_受給異動Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_受給異動Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_受給異動Ｆ_外部ＣＳＶファイル名, 受給異動Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_受給突合Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_受給突合Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_受給突合Ｆ_外部ＣＳＶファイル名, 受給突合Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_償還Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_償還Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_償還Ｆ_外部ＣＳＶファイル名, 償還Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_支給申請Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_支給申請Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_支給申請Ｆ_外部ＣＳＶファイル名, 支給申請Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_補正自己負担Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_補正自己負担Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_補正自己負担Ｆ_外部ＣＳＶファイル名, 補正自己負担Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_計算結果連絡Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_計算結果連絡Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_計算結果連絡Ｆ_外部ＣＳＶファイル名, 計算結果連絡Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_合算給付実績Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_合算給付実績Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_合算給付実績Ｆ_外部ＣＳＶファイル名, 合算給付実績Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_過誤申立総合Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_過誤申立総合Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_過誤申立総合Ｆ_外部ＣＳＶファイル名, 過誤申立総合Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連送付媒体_受給訂正Ｆ_ファイル名称, ConfigNameDBC.国保連送付媒体_受給訂正Ｆ_媒体区分,
                ConfigNameDBC.国保連送付媒体_受給訂正Ｆ_外部ＣＳＶファイル名, 受給訂正Ｆ));
        div.getDataGrid1().setDataSource(dataSource);
    }

    private DataGrid1_Row setRow値(Enum key0, Enum key1, Enum key2, RString key3) {
        DataGrid1_Row row = new DataGrid1_Row();
        row.setDefaultDataName0(getConfig値(key0));
        if (媒体コンフィグ値1.equals(getConfig値(key1))) {
            row.setDefaultDataName1(媒体文言1);
        }
        if (媒体コンフィグ値2.equals(getConfig値(key1))) {
            row.setDefaultDataName1(媒体文言2);
        }
        if (媒体コンフィグ値4.equals(getConfig値(key1))) {
            row.setDefaultDataName1(媒体文言4);
        }
        if (媒体コンフィグ値5.equals(getConfig値(key1))) {
            row.setDefaultDataName1(媒体文言5);
        }
        row.setDefaultDataName2(getConfig値(key2));
        row.setDefaultDataName3(key3);
        return row;
    }

    private RString getConfig値(Enum key) {
        return DbBusinessConfig.get(key, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
    }

    /**
     * 業務コンフィグの保存処理です。
     */
    public void config保存() {

        DataGrid1_Row row = div.getDataGrid1().getClickedItem();
        RString ファイル名称コンフィグ名 = row.getDefaultDataName3().concat(名称);
        RString ファイル名称コンフィグ値 = div.getTextBox1().getValue();
        RString 変更理由 = ResponseHolder.getMenuID().concat(更新);
        RDate 運用日 = RDate.getNowDate();
        BusinessConfig.update(SubGyomuCode.DBC介護給付, ConfigNameDBC.valueOf(ファイル名称コンフィグ名.toString()), ファイル名称コンフィグ値, 変更理由, RString.EMPTY, 運用日);
        RString 媒体コンフィグ名 = row.getDefaultDataName3().concat(媒体);
        RString 媒体コンフィグ値 = div.getTextBox2().getValue();
        BusinessConfig.update(SubGyomuCode.DBC介護給付, ConfigNameDBC.valueOf(媒体コンフィグ名.toString()), 媒体コンフィグ値, 変更理由, RString.EMPTY, 運用日);
        RString 外部ファイル名コンフィグ名 = row.getDefaultDataName3().concat(外部ＣＳＶ);
        RString 外部ファイル名コンフィグ値 = div.getTextBox3().getValue();
        BusinessConfig.update(SubGyomuCode.DBC介護給付, ConfigNameDBC.valueOf(外部ファイル名コンフィグ名.toString()), 外部ファイル名コンフィグ値, 変更理由, RString.EMPTY, 運用日);
    }

    /**
     * 国保連送付媒体指示一覧Gridの「選択」ボタン押下場合の処理です。
     */
    public void 選択ボタン押下時() {
        DataGrid1_Row row = div.getDataGrid1().getClickedItem();
        div.getTextBox1().setValue(row.getDefaultDataName0());
        div.getTextBox2().setValue(row.getDefaultDataName1());
        div.getTextBox3().setValue(row.getDefaultDataName2());
    }

    /**
     * 編集エリア：ファイル名称、媒体、外部ファイル名の項目値を破棄します。
     */
    public void set入力値破棄() {
        div.getTextBox1().clearValue();
        div.getTextBox2().clearValue();
        div.getTextBox3().clearValue();
    }

}
