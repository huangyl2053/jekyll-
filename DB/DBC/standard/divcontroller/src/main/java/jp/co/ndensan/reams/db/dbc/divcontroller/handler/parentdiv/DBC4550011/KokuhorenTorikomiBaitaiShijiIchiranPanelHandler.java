/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4550011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kanri.Baitai;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4550011.KokuhorenTorikomiBaitaiShijiIchiranPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4550011.dgKokuhorenTorikomiBaitaiShijiIchiran_Row;
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
 * 国保連取込媒体管理のHandlerクラスです。
 *
 * @reamsid_L DBC-3361-010 xuxin
 */
public class KokuhorenTorikomiBaitaiShijiIchiranPanelHandler {

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

    private final KokuhorenTorikomiBaitaiShijiIchiranPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 国保連取込媒体管理
     */
    public KokuhorenTorikomiBaitaiShijiIchiranPanelHandler(KokuhorenTorikomiBaitaiShijiIchiranPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期登録状態です。
     */
    public void 初期登録状態() {
        div.getBtnjikko().setDisabled(true);
        div.getBtnTorikeshi().setDisabled(true);
        div.getTxtFileMeisho().setDisabled(true);
        div.getDdlBaitai().setDisabled(true);
    }

    /**
     * 画面ロード時の動作です。
     */
    public void initialize() {
        init一覧Grid();
        init媒体DDL();
    }

    private void init一覧Grid() {
        List<dgKokuhorenTorikomiBaitaiShijiIchiran_Row> dataSource = new ArrayList<>();
        RDate 適用基準日 = RDate.getNowDate();
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_過誤決定Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_過誤決定Ｆ_媒体区分, 過誤決定Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_過誤決定公費Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_過誤決定公費Ｆ_媒体区分, 過誤決定公費Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_給付管理Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_給付管理Ｆ_媒体区分, 給付管理Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_給付実績Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_給付実績Ｆ_媒体区分, 給付実績Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_給付実績結果Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_給付実績結果Ｆ_媒体区分, 給付実績結果Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_共同更新Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_共同更新Ｆ_媒体区分, 共同更新Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_共同受給Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_共同受給Ｆ_媒体区分, 共同受給Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_公費一覧Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_公費一覧Ｆ_媒体区分, 公費一覧Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_高額決定者Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_高額決定者Ｆ_媒体区分, 高額決定者Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_高額対象者Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_高額対象者Ｆ_媒体区分, 高額対象者Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_再審決定Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_再審決定Ｆ_媒体区分, 再審決定Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_再審決定公費Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_再審決定公費Ｆ_媒体区分, 再審決定公費Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_受給更新Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_受給更新Ｆ_媒体区分, 受給更新Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_受給台帳Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_受給台帳Ｆ_媒体区分, 受給台帳Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_受給突合結果Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_受給突合結果Ｆ_媒体区分, 受給突合結果Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_償還支給Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_償還支給Ｆ_媒体区分, 償還支給Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_償還不支給Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_償還不支給Ｆ_媒体区分, 償還不支給Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_審査請求Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_審査請求Ｆ_媒体区分, 審査請求Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_請求通知Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_請求通知Ｆ_媒体区分, 請求通知Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_請求通知公費Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_請求通知公費Ｆ_媒体区分, 請求通知公費Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_自己負担確認Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_自己負担確認Ｆ_媒体区分, 自己負担確認Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_自己負担証明Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_自己負担証明Ｆ_媒体区分, 自己負担証明Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_支給計算結果Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_支給計算結果Ｆ_媒体区分, 支給計算結果Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_合算支給通知Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_合算支給通知Ｆ_媒体区分, 合算支給通知Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_合算支給一覧Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_合算支給一覧Ｆ_媒体区分, 合算支給一覧Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_合算給付実績Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_合算給付実績Ｆ_媒体区分, 合算給付実績Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_過誤決定総合Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_過誤決定総合Ｆ_媒体区分, 過誤決定総合Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_請求通知総合Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_請求通知総合Ｆ_媒体区分, 請求通知総合Ｆ, 適用基準日));
        dataSource.add(setRow値(ConfigNameDBC.国保連取込媒体_審査請求総合Ｆ_ファイル名称, ConfigNameDBC.国保連取込媒体_審査請求総合Ｆ_媒体区分, 審査請求総合Ｆ, 適用基準日));
        div.getDgKokuhorenTorikomiBaitaiShijiIchiran().setDataSource(dataSource);
    }

    private void init媒体DDL() {
        div.getDdlBaitai().getDataSource().clear();
        List<KeyValueDataSource> dataSource媒体 = new ArrayList<>();
        for (Baitai item : Baitai.values()) {
            dataSource媒体.add(new KeyValueDataSource(item.getコード(), item.get名称()));
        }
        div.getDdlBaitai().setDataSource(dataSource媒体);
    }

    private dgKokuhorenTorikomiBaitaiShijiIchiran_Row setRow値(Enum key0, Enum key1, RString key2, RDate 適用基準日) {
        dgKokuhorenTorikomiBaitaiShijiIchiran_Row row = new dgKokuhorenTorikomiBaitaiShijiIchiran_Row();
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
        row.setDefaultDataName2(key2);
        return row;
    }

    private RString getConfig値(Enum key, RDate 適用基準日) {
        return DbBusinessConfig.get(key, 適用基準日, SubGyomuCode.DBC介護給付);
    }

    /**
     * 国保連取込媒体指示一覧Gridの「選択」ボタン押下時の状態です。
     */
    public void 選択状態() {
        div.getBtnjikko().setDisabled(false);
        div.getBtnTorikeshi().setDisabled(false);
        div.getTxtFileMeisho().setDisabled(true);
        div.getDdlBaitai().setDisabled(false);
    }

    /**
     * 国保連取込媒体指示一覧Gridの「選択」ボタン押下場合の処理です。
     */
    public void 選択ボタン押下時() {
        init媒体DDL();
        dgKokuhorenTorikomiBaitaiShijiIchiran_Row row = div.getDgKokuhorenTorikomiBaitaiShijiIchiran().getClickedItem();
        div.getTxtFileMeisho().setValue(row.getDefaultDataName0());
        div.getDdlBaitai().setSelectedValue(row.getDefaultDataName1());
    }

    /**
     * 編集エリア：ファイル名称、媒体の項目値を破棄します。
     */
    public void set入力値破棄() {
        div.getTxtFileMeisho().clearValue();
        set媒体DDL空白表示();
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
        List<dgKokuhorenTorikomiBaitaiShijiIchiran_Row> dataSource = div.getDgKokuhorenTorikomiBaitaiShijiIchiran().getDataSource();
        dgKokuhorenTorikomiBaitaiShijiIchiran_Row row = div.getDgKokuhorenTorikomiBaitaiShijiIchiran().getClickedItem();
        row.setDefaultDataName1(div.getDdlBaitai().getSelectedValue());
        row.setRowState(RowState.Modified);
        div.getDgKokuhorenTorikomiBaitaiShijiIchiran().setDataSource(dataSource);
    }

    /**
     * 修正の業務コンフィグを全部保存します。
     */
    public void config保存() {

        RString 保存のconfig名;
        RString 保存のconfig値;
        RString 変更理由 = ResponseHolder.getMenuID().concat(更新);
        RDate 運用日 = RDate.getNowDate();
        List<dgKokuhorenTorikomiBaitaiShijiIchiran_Row> dataSource = div.getDgKokuhorenTorikomiBaitaiShijiIchiran().getDataSource();
        for (dgKokuhorenTorikomiBaitaiShijiIchiran_Row row : dataSource) {
            if (RowState.Modified.equals(row.getRowState())) {
                保存のconfig名 = row.getDefaultDataName2().concat(媒体);
                保存のconfig値 = get媒体コード(row.getDefaultDataName1());
                BusinessConfig.update(SubGyomuCode.DBC介護給付, ConfigNameDBC.valueOf(保存のconfig名.toString()), 保存のconfig値, 変更理由, RString.EMPTY, 運用日);
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

}
