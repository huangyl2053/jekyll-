/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util.shikakuhennkorireki;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 資格変更ddlの初期化処理です。
 *
 * @reamsid_L DBA-1300-040 dingyi
 */
public final class ShikakuHenkoJiyuInitializer {

    private static final RString 資格変更履歴文字列 = new RString("資格変更履歴共有子Div");

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ShikakuHenkoJiyuInitializer() {
    }

    /**
     * 資格関連異動共有子Div内の変更事由ドロップダウンリストの初期化処理です（DBAMN52003_広域内市町村間異動（転出・転入）画面で使用される）。
     *
     * @param div 資格変更履歴共有子Div
     */
    public static void initializeFor広域内市町村間異動(ShikakuHenkoRirekiDiv div) {
        requireNonNull(div, UrSystemErrorMessages.値がnull.getReplacedMessage(資格変更履歴文字列.toString()));
        List<KeyValueDataSource> 変更事由DDL = new ArrayList<>();
        KeyValueDataSource 広域内転居 = new KeyValueDataSource(ShikakuHenkoJiyu.広域内転居.getコード(),
                ShikakuHenkoJiyu.広域内転居.get名称());
        変更事由DDL.add(広域内転居);
        div.getDdlHenkoJiyu().setDataSource(変更事由DDL);
    }

    /**
     * 資格関連異動共有子Div内の変更事由ドロップダウンリストの初期化処理です（DBAMN52004_広域後の広域内住所地特例適用画面で使用される）。
     *
     * @param div 資格変更履歴共有子Div
     */
    public static void initializeFor広域内住所地特例(ShikakuHenkoRirekiDiv div) {
        requireNonNull(div, UrSystemErrorMessages.値がnull.getReplacedMessage(資格変更履歴文字列.toString()));
        List<KeyValueDataSource> 変更事由DDL = new ArrayList<>();
        KeyValueDataSource 広住特適用 = new KeyValueDataSource(ShikakuHenkoJiyu.広住特適用.getコード(),
                ShikakuHenkoJiyu.広住特適用.get名称());
        KeyValueDataSource 広住特居住 = new KeyValueDataSource(ShikakuHenkoJiyu.広住特居住.getコード(),
                ShikakuHenkoJiyu.広住特居住.get名称());
        KeyValueDataSource 広住特転入 = new KeyValueDataSource(ShikakuHenkoJiyu.広住特転入.getコード(),
                ShikakuHenkoJiyu.広住特転入.get名称());
        KeyValueDataSource 広住特転居 = new KeyValueDataSource(ShikakuHenkoJiyu.広住特転居.getコード(),
                ShikakuHenkoJiyu.広住特転居.get名称());
        変更事由DDL.add(広住特適用);
        変更事由DDL.add(広住特居住);
        変更事由DDL.add(広住特転入);
        変更事由DDL.add(広住特転居);
        div.getDdlHenkoJiyu().setDataSource(変更事由DDL);
    }

    /**
     * 資格関連異動共有子Div内の変更事由ドロップダウンリストの初期化処理です（DBAMN52002_合併による住特・広住特例の解除画面で使用される）。
     *
     * @param div 資格変更履歴共有子Div
     */
    public static void initializeFor合併時住特解除(ShikakuHenkoRirekiDiv div) {
        requireNonNull(div, UrSystemErrorMessages.値がnull.getReplacedMessage(資格変更履歴文字列.toString()));
        List<KeyValueDataSource> 変更事由DDL = new ArrayList<>();
        KeyValueDataSource 合併 = new KeyValueDataSource(ShikakuHenkoJiyu.合併.getコード(),
                ShikakuHenkoJiyu.合併.get名称());
        変更事由DDL.add(合併);
        div.getDdlHenkoJiyu().setDataSource(変更事由DDL);
    }

    /**
     * 資格関連異動共有子Div内の変更事由ドロップダウンリストの初期化処理です（DBAMN52002_合併による住特・広住特例の解除画面で使用される）。
     *
     * @param div 資格変更履歴共有子Div
     */
    public static void initialize(ShikakuHenkoRirekiDiv div) {
        requireNonNull(div, UrSystemErrorMessages.値がnull.getReplacedMessage(資格変更履歴文字列.toString()));
        List<KeyValueDataSource> 変更事由DDL = new ArrayList<>();
        for (ShikakuHenkoJiyu 変更事由 : ShikakuHenkoJiyu.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(変更事由.getコード());
            keyValue.setValue(変更事由.get名称());
            変更事由DDL.add(keyValue);
        }
        div.getDdlHenkoJiyu().setDataSource(変更事由DDL);
    }

}
