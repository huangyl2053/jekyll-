/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4550011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4550011.DataGrid1_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4550011.Panel1Div;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 国保連取込媒体管理のHandlerクラスです。
 *
 * @reamsid_L DBC-3361-010 xuxin
 */
public class Panel1Handler {

    private final Panel1Div div;

    private static final RString 媒体コンフィグ値1 = new RString("1");
    private static final RString 媒体コンフィグ値2 = new RString("2");
    private static final RString 媒体コンフィグ値4 = new RString("4");
    private static final RString 媒体コンフィグ値5 = new RString("5");
    private static final RString 媒体文言1 = new RString("1:伝送");
    private static final RString 媒体文言2 = new RString("2:ＭＯ");
    private static final RString 媒体文言4 = new RString("4:ＦＤ");
    private static final RString 媒体文言5 = new RString("5:帳票");

    private static final RString 名称 = new RString("_ファイル名称");
    private static final RString 媒体 = new RString("_媒体区分");
    private static final RString 更新 = new RString("を使用して更新");

    private static final RString 過誤決定Ｆ = new RString("国保連取込媒体_過誤決定Ｆ");
    private static final RString 過誤決定公費Ｆ = new RString("国保連取込媒体_過誤決定公費Ｆ");
    private static final RString 給付管理Ｆ = new RString("国保連取込媒体_給付管理Ｆ");
    private static final RString 給付実績Ｆ = new RString("国保連取込媒体_給付実績Ｆ");
    private static final RString 給付実績結果Ｆ = new RString("国保連取込媒体_給付実績結果Ｆ");
    private static final RString 共同更新Ｆ = new RString("国保連取込媒体_共同更新Ｆ");
    private static final RString 共同受給Ｆ = new RString("国保連取込媒体_共同受給Ｆ");
    private static final RString 公費一覧Ｆ = new RString("国保連取込媒体_公費一覧Ｆ");
    private static final RString 高額決定者Ｆ = new RString("国保連取込媒体_高額決定者Ｆ");
    private static final RString 高額対象者Ｆ = new RString("国保連取込媒体_高額対象者Ｆ");
    private static final RString 再審決定Ｆ = new RString("国保連取込媒体_再審決定Ｆ");
    private static final RString 再審決定公費Ｆ = new RString("国保連取込媒体_再審決定公費Ｆ");
    private static final RString 受給更新Ｆ = new RString("国保連取込媒体_受給更新Ｆ");
    private static final RString 受給台帳Ｆ = new RString("国保連取込媒体_受給台帳Ｆ");
    private static final RString 受給突合結果Ｆ = new RString("国保連取込媒体_受給突合結果Ｆ");
    private static final RString 償還支給Ｆ = new RString("国保連取込媒体_償還支給Ｆ");
    private static final RString 償還不支給Ｆ = new RString("国保連取込媒体_償還不支給Ｆ");
    private static final RString 審査請求Ｆ = new RString("国保連取込媒体_審査請求Ｆ");
    private static final RString 請求通知Ｆ = new RString("国保連取込媒体_請求通知Ｆ");
    private static final RString 請求通知公費Ｆ = new RString("国保連取込媒体_請求通知公費Ｆ");
    private static final RString 自己負担確認Ｆ = new RString("国保連取込媒体_自己負担確認Ｆ");
    private static final RString 自己負担証明Ｆ = new RString("国保連取込媒体_自己負担証明Ｆ");
    private static final RString 支給計算結果Ｆ = new RString("国保連取込媒体_支給計算結果Ｆ");
    private static final RString 合算支給通知Ｆ = new RString("国保連取込媒体_合算支給通知Ｆ");
    private static final RString 合算支給一覧Ｆ = new RString("国保連取込媒体_合算支給一覧Ｆ");
    private static final RString 合算給付実績Ｆ = new RString("国保連取込媒体_合算給付実績Ｆ");
    private static final RString 過誤決定総合Ｆ = new RString("国保連取込媒体_過誤決定総合Ｆ");
    private static final RString 請求通知総合Ｆ = new RString("国保連取込媒体_請求通知総合Ｆ");
    private static final RString 審査請求総合Ｆ = new RString("国保連取込媒体_審査請求総合Ｆ");

    /**
     * コンストラクタです。
     *
     * @param div 国保連取込媒体管理
     */
    public Panel1Handler(Panel1Div div) {
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
    }

    /**
     * 画面ロード時の動作です。
     */
    public void initialize() {

        List<DataGrid1_Row> dataSource = new ArrayList<>();
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_過誤決定Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_過誤決定Ｆ_媒体区分, 過誤決定Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_過誤決定公費Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_過誤決定公費Ｆ_媒体区分, 過誤決定公費Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_給付管理Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_給付管理Ｆ_媒体区分, 給付管理Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_給付実績Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_給付実績Ｆ_媒体区分, 給付実績Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_給付実績結果Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_給付実績結果Ｆ_媒体区分, 給付実績結果Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_共同更新Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_共同更新Ｆ_媒体区分, 共同更新Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_共同受給Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_共同受給Ｆ_媒体区分, 共同受給Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_公費一覧Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_公費一覧Ｆ_媒体区分, 公費一覧Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_高額決定者Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_高額決定者Ｆ_媒体区分, 高額決定者Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_高額対象者Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_高額対象者Ｆ_媒体区分, 高額対象者Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_再審決定Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_再審決定Ｆ_媒体区分, 再審決定Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_再審決定公費Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_再審決定公費Ｆ_媒体区分, 再審決定公費Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_受給更新Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_受給更新Ｆ_媒体区分, 受給更新Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_受給台帳Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_受給台帳Ｆ_媒体区分, 受給台帳Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_受給突合結果Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_受給突合結果Ｆ_媒体区分, 受給突合結果Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_償還支給Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_償還支給Ｆ_媒体区分, 償還支給Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_償還不支給Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_償還不支給Ｆ_媒体区分, 償還不支給Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_審査請求Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_審査請求Ｆ_媒体区分, 審査請求Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_請求通知Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_請求通知Ｆ_媒体区分, 請求通知Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_請求通知公費Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_請求通知公費Ｆ_媒体区分, 請求通知公費Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_自己負担確認Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_自己負担確認Ｆ_媒体区分, 自己負担確認Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_自己負担証明Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_自己負担証明Ｆ_媒体区分, 自己負担証明Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_支給計算結果Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_支給計算結果Ｆ_媒体区分, 支給計算結果Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_合算支給通知Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_合算支給通知Ｆ_媒体区分, 合算支給通知Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_合算支給一覧Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_合算支給一覧Ｆ_媒体区分, 合算支給一覧Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_合算給付実績Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_合算給付実績Ｆ_媒体区分, 合算給付実績Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_過誤決定総合Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_過誤決定総合Ｆ_媒体区分, 過誤決定総合Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_請求通知総合Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_請求通知総合Ｆ_媒体区分, 請求通知総合Ｆ));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_審査請求総合Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_審査請求総合Ｆ_媒体区分, 審査請求総合Ｆ));
        div.getDataGrid1().setDataSource(dataSource);
    }

    private DataGrid1_Row setRow値(Enum key0, Enum key1, RString key2) {
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
        row.setDefaultDataName2(key2);
        return row;
    }

    private RString getConfig値(Enum key) {
        return DbBusinessConfig.get(key, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
    }

    /**
     * 国保連取込媒体指示一覧Gridの「選択」ボタン押下時の状態です。
     */
    public void 選択状態() {
        div.getButton1().setDisabled(false);
        div.getButton2().setDisabled(false);
        div.getTextBox1().setDisabled(true);
        div.getTextBox2().setDisabled(false);
    }

    /**
     * 国保連取込媒体指示一覧Gridの「選択」ボタン押下場合の処理です。
     */
    public void 選択ボタン押下時() {
        DataGrid1_Row row = div.getDataGrid1().getClickedItem();
        div.getTextBox1().setValue(row.getDefaultDataName0());
        div.getTextBox2().setValue(row.getDefaultDataName1());
    }

    /**
     * 編集エリア：ファイル名称、媒体の項目値を破棄します。
     */
    public void set入力値破棄() {
        div.getTextBox1().clearValue();
        div.getTextBox2().clearValue();
    }

    /**
     * 業務コンフィグの保存処理です。
     */
    public void config保存() {

        DataGrid1_Row row = div.getDataGrid1().getClickedItem();
        RString ファイル名称コンフィグ名 = row.getDefaultDataName2().concat(名称);
        RString ファイル名称コンフィグ値 = div.getTextBox1().getValue();
        RString 変更理由 = ResponseHolder.getMenuID().concat(更新);
        RDate 運用日 = RDate.getNowDate();
        BusinessConfig.update(SubGyomuCode.DBC介護給付, ConfigNameDBC.valueOf(ファイル名称コンフィグ名.toString()), ファイル名称コンフィグ値, 変更理由, RString.EMPTY, 運用日);
        RString 媒体コンフィグ名 = row.getDefaultDataName2().concat(媒体);
        RString 媒体コンフィグ値 = div.getTextBox2().getValue();
        BusinessConfig.update(SubGyomuCode.DBC介護給付, ConfigNameDBC.valueOf(媒体コンフィグ名.toString()), 媒体コンフィグ値, 変更理由, RString.EMPTY, 運用日);
    }

}
