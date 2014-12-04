/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.入力補助;
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

    private enum ddl台帳種別key {

        ddlDaichoShubetsu01Key("1"),
        ddlDaichoShubetsu02Key("3"),
        ddlDaichoShubetsu03Key("2");

        private final RString key;

        private ddl台帳種別key(String key) {
            this.key = new RString(key);
        }

        /**
         * RString型のDropDownList台帳種別のkeyを返します。
         *
         * @return 台帳種別のkey
         */
        public RString getKey() {
            return key;
        }
    }

    private enum ddl台帳種別value {

        ddlDaichoShubetsu01Value("被保台帳"),
        ddlDaichoShubetsu02Value("他市町村住所地特例者"),
        ddlDaichoShubetsu03Value("適用除外者");

        private final RString value;

        private ddl台帳種別value(String value) {
            this.value = new RString(value);
        }

        /**
         * RString型のDropDownList台帳種別のvalueを返します。
         *
         * @return 台帳種別のvalue
         */
        public RString getValue() {
            return value;
        }
    }

    private enum rad施設種類key {

        radShisetsuShurui01Key("11"),
        radShisetsuShurui02Key("12"),
        radShisetsuShurui03Key("21");

        private final RString key;

        private rad施設種類key(String key) {
            this.key = new RString(key);
        }

        /**
         * RString型のラジオボタン施設種類のkeyを返します。
         *
         * @return 施設種類のkey
         */
        public RString getKey() {
            return key;
        }
    }

    private enum rad施設種類value {

        radShisetsuShurui01Value("介護保険施設"),
        radShisetsuShurui02Value("その他特例施設"),
        radShisetsuShurui03Value("適用除外施設");

        private final RString value;

        private rad施設種類value(String value) {
            this.value = new RString(value);
        }

        /**
         * RString型のラジオボタン施設種類のvalueを返します。
         *
         * @return 施設種類のvalue
         */
        public RString getValue() {
            return value;
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
        div.getDdlDaichoShubetsu().setDataSource(createDdl台帳種別DataSource());
        switch (div.getMode_利用機能()) {
            case 台帳種別表示機能:
                div.setMode_台帳種別(台帳種別.台帳種別表示する);
                div.setMode_施設種類(施設種類.施設種類を表示する);
                div.getRadShisetsuShurui().setDataSource(createRadDataSource2());
                div.getRadShisetsuShurui().setSelectedKey(rad施設種類key.radShisetsuShurui01Key.getKey());
                select施設種類();
                break;
            case 全施設対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.setMode_施設種類(施設種類.施設種類を表示する);
                div.getRadShisetsuShurui().setDataSource(createRadDataSource3());
                div.getRadShisetsuShurui().setSelectedKey(rad施設種類key.radShisetsuShurui01Key.getKey());
                select施設種類();
                break;
            case 被保険者対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.getDdlDaichoShubetsu().setSelectedKey(ddl台帳種別key.ddlDaichoShubetsu01Key.getKey());
                div.getRadShisetsuShurui().setDataSource(createRadDataSource2());
                div.getRadShisetsuShurui().setSelectedKey(rad施設種類key.radShisetsuShurui01Key.getKey());
                select台帳種別();
                break;
            case 他市町村住所地特例者対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.getDdlDaichoShubetsu().setSelectedKey(ddl台帳種別key.ddlDaichoShubetsu02Key.getKey());
                div.getRadShisetsuShurui().setDataSource(createRadDataSource2());
                div.getRadShisetsuShurui().setSelectedKey(rad施設種類key.radShisetsuShurui02Key.getKey());
                select台帳種別();
                break;
            case 適用除外者対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.getDdlDaichoShubetsu().setSelectedKey(ddl台帳種別key.ddlDaichoShubetsu03Key.getKey());
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

        if (selectedKey.equals(ddl台帳種別key.ddlDaichoShubetsu01Key.getKey())) {
            div.getRadShisetsuShurui().setSelectedKey(rad施設種類key.radShisetsuShurui01Key.getKey());
            div.setMode_施設種類(施設種類.施設種類を表示する);
            div.setMode_入力補助(入力補助.事業者を表示する);

        } else if (selectedKey.equals(ddl台帳種別key.ddlDaichoShubetsu02Key.getKey())) {
            div.getRadShisetsuShurui().setSelectedKey(rad施設種類key.radShisetsuShurui02Key.getKey());
            div.setMode_施設種類(施設種類.施設種類を表示する);
            div.setMode_入力補助(入力補助.他特例施設を表示する);

        } else if (selectedKey.equals(ddl台帳種別key.ddlDaichoShubetsu03Key.getKey())) {
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

        if (selectedKey.equals(rad施設種類key.radShisetsuShurui01Key.getKey())) {
            div.setMode_入力補助(入力補助.事業者を表示する);

        } else if (selectedKey.equals(rad施設種類key.radShisetsuShurui02Key.getKey())) {
            div.setMode_入力補助(入力補助.他特例施設を表示する);

        } else if (selectedKey.equals(rad施設種類key.radShisetsuShurui03Key.getKey())) {
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
                return rad施設種類value.radShisetsuShurui01Value.getValue();
            case 他特例施設を表示する:
                return rad施設種類value.radShisetsuShurui02Value.getValue();
            case 除外施設を表示する:
                return rad施設種類value.radShisetsuShurui03Value.getValue();
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
                return rad施設種類key.radShisetsuShurui01Key.getKey();
            case 他特例施設を表示する:
                return rad施設種類key.radShisetsuShurui02Key.getKey();
            case 除外施設を表示する:
                return rad施設種類key.radShisetsuShurui03Key.getKey();
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

    private List<KeyValueDataSource> createDdl台帳種別DataSource() {

        KeyValueDataSource hihokenshaDaicho = new KeyValueDataSource(ddl台帳種別key.ddlDaichoShubetsu01Key.getKey(),
                ddl台帳種別value.ddlDaichoShubetsu01Value.getValue());
        KeyValueDataSource taTokurei = new KeyValueDataSource(ddl台帳種別key.ddlDaichoShubetsu02Key.getKey(),
                ddl台帳種別value.ddlDaichoShubetsu02Value.getValue());
        KeyValueDataSource tekiyoJogai = new KeyValueDataSource(ddl台帳種別key.ddlDaichoShubetsu03Key.getKey(),
                ddl台帳種別value.ddlDaichoShubetsu03Value.getValue());

        List<KeyValueDataSource> src = new ArrayList<>();
        src.add(hihokenshaDaicho);
        src.add(taTokurei);
        src.add(tekiyoJogai);

        return src;
    }

    private List<KeyValueDataSource> createRadDataSource2() {

        KeyValueDataSource kaigoHokenShisetsu = new KeyValueDataSource(rad施設種類key.radShisetsuShurui01Key.getKey(),
                rad施設種類value.radShisetsuShurui01Value.getValue());
        KeyValueDataSource other = new KeyValueDataSource(rad施設種類key.radShisetsuShurui02Key.getKey(),
                rad施設種類value.radShisetsuShurui02Value.getValue());

        List<KeyValueDataSource> src = new ArrayList<>();
        src.add(kaigoHokenShisetsu);
        src.add(other);

        return src;
    }

    private List<KeyValueDataSource> createRadDataSource3() {

        KeyValueDataSource kaigoHokenShisetsu = new KeyValueDataSource(rad施設種類key.radShisetsuShurui01Key.getKey(),
                rad施設種類value.radShisetsuShurui01Value.getValue());
        KeyValueDataSource other = new KeyValueDataSource(rad施設種類key.radShisetsuShurui02Key.getKey(),
                rad施設種類value.radShisetsuShurui02Value.getValue());
        KeyValueDataSource tekiyoJogaiShisetsu = new KeyValueDataSource(rad施設種類key.radShisetsuShurui03Key.getKey(),
                rad施設種類value.radShisetsuShurui03Value.getValue());

        List<KeyValueDataSource> src = new ArrayList<>();
        src.add(kaigoHokenShisetsu);
        src.add(other);
        src.add(tekiyoJogaiShisetsu);

        return src;
    }

}
