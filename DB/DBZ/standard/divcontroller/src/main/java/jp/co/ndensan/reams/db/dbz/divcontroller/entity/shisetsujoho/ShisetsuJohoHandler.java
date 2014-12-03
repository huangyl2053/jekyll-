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

    private final RString ddlDaichoShubetsu01Key = new RString("1");
    private final RString ddlDaichoShubetsu02Key = new RString("3");
    private final RString ddlDaichoShubetsu03Key = new RString("2");

    private final RString radShisetsuShurui01Key = new RString("11");
    private final RString radShisetsuShurui02Key = new RString("12");
    private final RString radShisetsuShurui03Key = new RString("21");

    private final RString radShisetsuShurui01Value = new RString("介護保険施設");
    private final RString radShisetsuShurui02Value = new RString("その他特例施設");
    private final RString radShisetsuShurui03Value = new RString("適用除外施設");

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
        switch (div.getMode_利用機能()) {
            case 台帳種別表示機能:
                div.setMode_台帳種別(台帳種別.台帳種別表示する);
                div.setMode_施設種類(施設種類.施設種類を表示する);
                div.getRadShisetsuShurui().setDataSource(createRadDataSource2());
                div.getRadShisetsuShurui().setSelectedKey(radShisetsuShurui01Key);
                select施設種類();
                break;
            case 全施設対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.setMode_施設種類(施設種類.施設種類を表示する);
                div.getRadShisetsuShurui().setDataSource(createRadDataSource3());
                div.getRadShisetsuShurui().setSelectedKey(radShisetsuShurui01Key);
                select施設種類();
                break;
            case 被保険者対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.getDdlDaichoShubetsu().setSelectedKey(ddlDaichoShubetsu01Key);
                div.getRadShisetsuShurui().setDataSource(createRadDataSource2());
                div.getRadShisetsuShurui().setSelectedKey(radShisetsuShurui01Key);
                select台帳種別();
                break;
            case 他市町村住所地特例者対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.getDdlDaichoShubetsu().setSelectedKey(ddlDaichoShubetsu02Key);
                div.getRadShisetsuShurui().setDataSource(createRadDataSource2());
                div.getRadShisetsuShurui().setSelectedKey(radShisetsuShurui02Key);
                select台帳種別();
                break;
            case 適用除外者対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.getDdlDaichoShubetsu().setSelectedKey(ddlDaichoShubetsu03Key);
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

        RString selectedKey = div.getDdlDaichoShubetsu().getSelectedKey();
        if (selectedKey != null) {
            if (selectedKey.equals(ddlDaichoShubetsu01Key)) {
                div.getRadShisetsuShurui().setSelectedKey(radShisetsuShurui01Key);
                div.setMode_施設種類(施設種類.施設種類を表示する);
                div.setMode_入力補助(入力補助.事業者を表示する);

            } else if (selectedKey.equals(ddlDaichoShubetsu02Key)) {
                div.getRadShisetsuShurui().setSelectedKey(radShisetsuShurui02Key);
                div.setMode_施設種類(施設種類.施設種類を表示する);
                div.setMode_入力補助(入力補助.他特例施設を表示する);

            } else if (selectedKey.equals(ddlDaichoShubetsu03Key)) {
                div.setMode_施設種類(施設種類.施設種類を表示しない);
                div.setMode_入力補助(入力補助.除外施設を表示する);

            }
        }

        clearTxt();
    }

    /**
     * 選択された施設種類を元に入力補助ボタンの表示を変更する処理です。
     */
    public void select施設種類() {

        RString selectedKey = div.getRadShisetsuShurui().getSelectedKey();
        if (selectedKey != null) {
            if (selectedKey.equals(radShisetsuShurui01Key)) {
                div.setMode_入力補助(入力補助.事業者を表示する);

            } else if (selectedKey.equals(radShisetsuShurui02Key)) {
                div.setMode_入力補助(入力補助.他特例施設を表示する);

            } else if (selectedKey.equals(radShisetsuShurui03Key)) {
                div.setMode_入力補助(入力補助.除外施設を表示する);

            }
        }

        clearTxt();
    }

    /**
     * 施設種類を返します。
     *
     * @return 施設種類
     */
    public RString get施設種類() {

        RString 施設種類 = RString.EMPTY;
        switch (div.getMode_入力補助()) {
            case 事業者を表示する:
                施設種類 = radShisetsuShurui01Value;
                break;
            case 他特例施設を表示する:
                施設種類 = radShisetsuShurui02Value;
                break;
            case 除外施設を表示する:
                施設種類 = radShisetsuShurui03Value;
                break;
            default:
                break;
        }

        return 施設種類;
    }

    /**
     * 施設種類キーを返します。
     *
     * @return 施設種類キー
     */
    public RString get施設種類キー() {

        RString 施設種類キー = RString.EMPTY;
        switch (div.getMode_入力補助()) {
            case 事業者を表示する:
                施設種類キー = radShisetsuShurui01Key;
                break;
            case 他特例施設を表示する:
                施設種類キー = radShisetsuShurui02Key;
                break;
            case 除外施設を表示する:
                施設種類キー = radShisetsuShurui03Key;
                break;
            default:
                break;
        }

        return 施設種類キー;
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

    private List<KeyValueDataSource> createRadDataSource2() {

        KeyValueDataSource kaigoHokenShisetsu = new KeyValueDataSource(radShisetsuShurui01Key, radShisetsuShurui01Value);
        KeyValueDataSource other = new KeyValueDataSource(radShisetsuShurui02Key, radShisetsuShurui02Value);

        List<KeyValueDataSource> src = new ArrayList<>();
        src.add(kaigoHokenShisetsu);
        src.add(other);

        return src;
    }

    private List<KeyValueDataSource> createRadDataSource3() {

        KeyValueDataSource kaigoHokenShisetsu = new KeyValueDataSource(radShisetsuShurui01Key, radShisetsuShurui01Value);
        KeyValueDataSource other = new KeyValueDataSource(radShisetsuShurui02Key, radShisetsuShurui02Value);
        KeyValueDataSource tekiyoJogaiShisetsu = new KeyValueDataSource(radShisetsuShurui03Key, radShisetsuShurui03Value);

        List<KeyValueDataSource> src = new ArrayList<>();
        src.add(kaigoHokenShisetsu);
        src.add(other);
        src.add(tekiyoJogaiShisetsu);

        return src;
    }

}
