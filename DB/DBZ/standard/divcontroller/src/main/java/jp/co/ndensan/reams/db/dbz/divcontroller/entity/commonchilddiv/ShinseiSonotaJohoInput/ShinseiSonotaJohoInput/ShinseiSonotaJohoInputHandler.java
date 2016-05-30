/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.SakujoJiyuCode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv.ShoriType.IchibuSoshitsuMode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv.ShoriType.JukyuShikakushashoMode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv.ShoriType.KyakkaMode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv.ShoriType.NinteiMode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv.ShoriType.ShokaiMode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv.ShoriType.ShokkenKisaiMode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv.ShoriType.TokushuRirekiShuseiMode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv.ShoriType.TokushuSakujyoMode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv.ShoriType.TokushuShuseiMode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv.ShoriType.TokushuTsuikaMode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv.ShoriType.TorikeshiMode;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv.ShoriType.ZenbuSoshitsuMode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 共有子Div「申請その他情報」の実装クラスです。
 *
 * @reamsid_L DBE-1300-120 houtianpeng
 */
public class ShinseiSonotaJohoInputHandler {

    private final ShinseiSonotaJohoInputDiv div;
    private final RString 通常 = new RString("0");
    private final RString 職権取消 = new RString("1");
    private final RString 取得事由 = new RString("2");
    private final RString 却下事由 = new RString("3");
    private final RString 申請取消事由 = new RString("4");

    /**
     * コンストラクタです。
     *
     * @param div 申請その他情報Div
     */
    public ShinseiSonotaJohoInputHandler(ShinseiSonotaJohoInputDiv div) {
        this.div = div;
    }

    /**
     * 初期化を行います。
     */
    public void initialize() {
        clear();
        状態の設定();
        移動事由ddlの設定();
        div.getDdlSakujoJiyu().setDataSource(get削除事由ddl());
    }

    /**
     * 入力値をクリアします。
     */
    public void clear() {
        div.getDdlIdoJiyu().setSelectedKey(DropDownList.BLANKLINE_KEY);
        div.getDdlSakujoJiyu().setSelectedKey(DropDownList.BLANKLINE_KEY);
        div.getTxtRiyu().clearValue();
        div.getTxtSoshitsuDay().clearValue();
        div.getTxtTorisageDay().clearValue();
        div.getTxtToshoNinteiKikanFrom().clearValue();
        div.getTxtToshoNinteiKikanTo().clearValue();
        div.getTxtJukyuShikakuHakkoDay1().clearValue();
        div.getTxtJukyuShikakuHakkoDay2().clearValue();
    }

    private void 移動事由ddlの設定() {

        switch (div.getMode_ShoriType()) {
            case ZenbuSoshitsuMode:
            case IchibuSoshitsuMode:
                div.getDdlIdoJiyu().setDataSource(get移動事由ddl_職権取消());
                break;
            case TokushuTsuikaMode:
            case TokushuShuseiMode:
            case ShokkenKisaiMode:
                div.getDdlIdoJiyu().setDataSource(get移動事由ddl_取得事由());
                break;
            case KyakkaMode:
                div.getDdlIdoJiyu().setDataSource(get移動事由ddl_却下事由());
                break;
            case TorikeshiMode:
                div.getDdlIdoJiyu().setDataSource(get移動事由ddl_申請取消事由());
                break;
            case TokushuRirekiShuseiMode:
            case JukyuShikakushashoMode:
            case ShokaiMode:
            case TokushuSakujyoMode:
                div.getDdlIdoJiyu().setDataSource(get移動事由ddl());
                break;
            case NinteiMode:
                div.getDdlIdoJiyu().setDataSource(get移動事由ddl_通常());
                break;
            default:
                break;
        }
    }

    private void 状態の設定() {

        switch (div.getMode_ShoriType()) {
            case TokushuTsuikaMode:
                div.setMode_ShoriType(TokushuTsuikaMode);
                break;
            case TokushuShuseiMode:
                div.setMode_ShoriType(TokushuShuseiMode);
                break;
            case TokushuSakujyoMode:
                div.setMode_ShoriType(TokushuSakujyoMode);
                break;
            case TokushuRirekiShuseiMode:
                div.setMode_ShoriType(TokushuRirekiShuseiMode);
                break;
            case NinteiMode:
                div.setMode_ShoriType(NinteiMode);
                break;
            case KyakkaMode:
                div.setMode_ShoriType(KyakkaMode);
                break;
            case ShokkenKisaiMode:
                div.setMode_ShoriType(ShokkenKisaiMode);
                break;
            case TorikeshiMode:
                div.setMode_ShoriType(TorikeshiMode);
                break;
            case ZenbuSoshitsuMode:
                div.setMode_ShoriType(ZenbuSoshitsuMode);
                break;
            case IchibuSoshitsuMode:
                div.setMode_ShoriType(IchibuSoshitsuMode);
                break;
            case JukyuShikakushashoMode:
                div.setMode_ShoriType(JukyuShikakushashoMode);
                break;
            case ShokaiMode:
                div.setMode_ShoriType(ShokaiMode);
                break;
            default:
                break;
        }
    }

    private List<KeyValueDataSource> get移動事由ddl_通常() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (Datakubun target : Datakubun.values()) {
            if (target.getコード().startsWith(通常)) {
                KeyValueDataSource keyValueData = new KeyValueDataSource(target.getコード(), target.get名称());
                dataSource.add(keyValueData);
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get移動事由ddl_職権取消() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (Datakubun target : Datakubun.values()) {
            if (target.getコード().startsWith(職権取消)) {
                KeyValueDataSource keyValueData = new KeyValueDataSource(target.getコード(), target.get名称());
                dataSource.add(keyValueData);
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get移動事由ddl_取得事由() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (Datakubun target : Datakubun.values()) {
            if (target.getコード().startsWith(取得事由)) {
                KeyValueDataSource keyValueData = new KeyValueDataSource(target.getコード(), target.get名称());
                dataSource.add(keyValueData);
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get移動事由ddl_却下事由() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (Datakubun target : Datakubun.values()) {
            if (target.getコード().startsWith(却下事由)) {
                KeyValueDataSource keyValueData = new KeyValueDataSource(target.getコード(), target.get名称());
                dataSource.add(keyValueData);
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get移動事由ddl_申請取消事由() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (Datakubun target : Datakubun.values()) {
            if (target.getコード().startsWith(申請取消事由)) {
                KeyValueDataSource keyValueData = new KeyValueDataSource(target.getコード(), target.get名称());
                dataSource.add(keyValueData);
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get移動事由ddl() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (Datakubun target : Datakubun.values()) {
            KeyValueDataSource keyValueData = new KeyValueDataSource(target.getコード(), target.get名称());
            dataSource.add(keyValueData);
        }
        return dataSource;
    }


    private List<KeyValueDataSource> get削除事由ddl() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (SakujoJiyuCode target : SakujoJiyuCode.values()) {
            KeyValueDataSource keyValueData = new KeyValueDataSource(target.getコード(), target.get名称());
            dataSource.add(keyValueData);
        }
        return dataSource;
    }
}
