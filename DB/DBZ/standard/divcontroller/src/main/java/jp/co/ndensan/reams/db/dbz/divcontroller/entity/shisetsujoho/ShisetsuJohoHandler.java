/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.入力補助;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.利用機能;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.台帳種別;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.施設種類;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.表示モード;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 施設情報共有子Divのエンティティに対する操作を行うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShisetsuJohoHandler {

    private final ShisetsuJohoDiv div;

    private enum DaichoShubetsu {

        被保台帳("1"),
        他市町村住所地特例者("3"),
        適用除外者("2");
        private final RString key;
        private final RString value;

        private DaichoShubetsu(String key) {
            this.key = new RString(key);
            this.value = new RString(name());
        }

        RString getKey() {
            return this.key;
        }

        RString getValue() {
            return this.value;
        }
    }

    private enum ShisetsuShurui {

        介護保険施設("11"),
        その他特例施設("12"),
        適用除外施設("21");
        private final RString key;
        private final RString value;

        private ShisetsuShurui(String key) {
            this.key = new RString(key);
            this.value = new RString(name());
        }

        RString getKey() {
            return this.key;
        }

        RString getValue() {
            return this.value;
        }
    }

    /**
     * コンストラクタです。
     *
     * @param div 施設情報共有子Divのエンティティ
     */
    public ShisetsuJohoHandler(ShisetsuJohoDiv div) {
        this.div = div;
    }

    /**
     * 初期化処理です。
     */
    public void initialize() {
        div.getDdlDaichoShubetsu().setDataSource(createDdl台帳種別DataSource(DaichoShubetsu.values()));
        switch (div.getMode_利用機能()) {
            case 台帳種別表示機能:
                div.setMode_台帳種別(台帳種別.台帳種別表示する);
                div.setMode_施設種類(施設種類.施設種類を表示する);
                div.getRadShisetsuShurui().setDataSource(createRad施設情報DataSource());
                div.getRadShisetsuShurui().setSelectedKey(ShisetsuShurui.介護保険施設.getKey());
                select施設種類();
                break;
            case 全施設対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.setMode_施設種類(施設種類.施設種類を表示する);
                div.getRadShisetsuShurui().setDataSource(createRad施設情報DataSource());
                div.getRadShisetsuShurui().setSelectedKey(ShisetsuShurui.介護保険施設.getKey());
                select施設種類();
                break;
            case 被保険者対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.getDdlDaichoShubetsu().setSelectedKey(DaichoShubetsu.被保台帳.getKey());
                div.getRadShisetsuShurui().setDataSource(createRad施設情報DataSource());
                div.getRadShisetsuShurui().setSelectedKey(ShisetsuShurui.介護保険施設.getKey());
                select台帳種別();
                break;
            case 他市町村住所地特例者対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.getDdlDaichoShubetsu().setSelectedKey(DaichoShubetsu.他市町村住所地特例者.getKey());
                div.getRadShisetsuShurui().setDataSource(createRad施設情報DataSource());
                div.getRadShisetsuShurui().setSelectedKey(ShisetsuShurui.その他特例施設.getKey());
                select台帳種別();
                break;
            case 適用除外者対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.getDdlDaichoShubetsu().setSelectedKey(DaichoShubetsu.適用除外者.getKey());
                select台帳種別();
                break;
            default:
                break;
        }

        clearTxt();
    }

    /**
     * 選択された台帳種別を元にラジオボタンの表示を変更する処理です。
     */
    public void select台帳種別() {

        clearTxt();

        RString selectedKey = div.getDdlDaichoShubetsu().getSelectedKey();
        if (selectedKey == null) {
            return;
        }

        if (selectedKey.equals(DaichoShubetsu.被保台帳.getKey())) {
            div.getRadShisetsuShurui().setSelectedKey(ShisetsuShurui.介護保険施設.getKey());
            div.setMode_施設種類(施設種類.施設種類を表示する);
            div.setMode_入力補助(入力補助.事業者を表示する);

        } else if (selectedKey.equals(DaichoShubetsu.他市町村住所地特例者.getKey())) {
            div.getRadShisetsuShurui().setSelectedKey(ShisetsuShurui.その他特例施設.getKey());
            div.setMode_施設種類(施設種類.施設種類を表示する);
            div.setMode_入力補助(入力補助.他特例施設を表示する);

        } else if (selectedKey.equals(DaichoShubetsu.適用除外者.getKey())) {
            div.setMode_施設種類(施設種類.施設種類を表示しない);
            div.setMode_入力補助(入力補助.除外施設を表示する);

        }
    }

    /**
     * 選択された施設種類を元に入力補助ボタンの表示を変更する処理です。
     */
    public void select施設種類() {

        clearTxt();

        RString selectedKey = div.getRadShisetsuShurui().getSelectedKey();
        if (selectedKey == null) {
            return;
        }

        if (selectedKey.equals(ShisetsuShurui.介護保険施設.getKey())) {
            div.setMode_入力補助(入力補助.事業者を表示する);

        } else if (selectedKey.equals(ShisetsuShurui.その他特例施設.getKey())) {
            div.setMode_入力補助(入力補助.他特例施設を表示する);

        } else if (selectedKey.equals(ShisetsuShurui.適用除外施設.getKey())) {
            div.setMode_入力補助(入力補助.除外施設を表示する);

        }
    }

    /**
     * 施設種類を返します。
     *
     * @return 施設種類
     */
    public RString get施設種類() {
        switch (div.getMode_入力補助()) {
            case 事業者を表示する:
                return ShisetsuShurui.介護保険施設.getValue();
            case 他特例施設を表示する:
                return ShisetsuShurui.その他特例施設.getValue();
            case 除外施設を表示する:
                return ShisetsuShurui.適用除外施設.getValue();
            default:
                return RString.EMPTY;
        }
    }

    /**
     * 施設種類キーを返します。
     *
     * @return 施設種類キー
     */
    public RString get施設種類キー() {
        switch (div.getMode_入力補助()) {
            case 事業者を表示する:
                return ShisetsuShurui.介護保険施設.getKey();
            case 他特例施設を表示する:
                return ShisetsuShurui.その他特例施設.getKey();
            case 除外施設を表示する:
                return ShisetsuShurui.適用除外施設.getKey();
            default:
                return RString.EMPTY;
        }
    }

    /**
     * 施設コードを元に施設名称を取得します。
     */
    public void get施設名称() {
        RString code = div.getTxtShisetsuCode().getValue();
        RString meisho = RString.EMPTY;
        if (!code.isEmpty()) {
            switch (div.getMode_入力補助()) {
                case 事業者を表示する:
                    // TODO N8187 久保田 事業者入力ガイド(JigyoshaInputGuide)の施設名称取得機能を使用して、施設名称を取得する。2014/12/31期限。
                    meisho = new RString("テスト事業者");
                    break;
                case 他特例施設を表示する:
                    // TODO N8187 久保田 その他特例施設入力ガイド(OtherTokureiShisetsuInputGuide)の施設名称取得機能を使用して、施設名称を取得する。2014/12/31期限。
                    meisho = new RString("テスト他特例施設");
                    break;
                case 除外施設を表示する:
                    // TODO N8187 久保田 適用除外施設入力ガイド(TekiyoJogaiShisetsuInputGuide)の施設名称取得機能を使用して、施設名称を取得する。2014/12/31期限。
                    meisho = new RString("テスト除外施設");
                    break;
                default:
                    break;
            }
        }

        div.getTxtShisetsuMeisho().setValue(meisho);
    }

    /**
     * 施設情報共有子Divを入力可の状態にします。
     */
    public void set入力可() {
        div.setMode_表示モード(表示モード.defaultView);
    }

    /**
     * 施設情報共有子Divを入力不可の状態にします。
     */
    public void set入力不可() {
        div.setMode_表示モード(表示モード.readOnly);
    }

    /**
     * 施設コードと施設名称をクリアします。
     */
    public void clearTxt() {
        div.getTxtShisetsuCode().clearValue();
        div.getTxtShisetsuMeisho().clearValue();
    }

    private List<KeyValueDataSource> createDdl台帳種別DataSource(DaichoShubetsu[] items) {

        List<KeyValueDataSource> list = new ArrayList<>();
        for (DaichoShubetsu item : items) {
            list.add(new KeyValueDataSource(item.getKey(), item.getValue()));
        }

        return list;
    }

    private List<KeyValueDataSource> createRad施設情報DataSource() {

        List<KeyValueDataSource> list = new ArrayList<>();

        list.add(new KeyValueDataSource(ShisetsuShurui.介護保険施設.getKey(),
                ShisetsuShurui.介護保険施設.getValue()));
        list.add(new KeyValueDataSource(ShisetsuShurui.その他特例施設.getKey(),
                ShisetsuShurui.その他特例施設.getValue()));
        if (div.getMode_利用機能() == 利用機能.全施設対象機能) {
            list.add(new KeyValueDataSource(ShisetsuShurui.適用除外施設.getKey(),
                    ShisetsuShurui.適用除外施設.getValue()));
        }

        return list;
    }

}
