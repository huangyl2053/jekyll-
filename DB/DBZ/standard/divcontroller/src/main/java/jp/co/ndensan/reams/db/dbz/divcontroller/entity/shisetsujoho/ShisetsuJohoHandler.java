/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.入力補助;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.利用機能;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.台帳種別;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.施設種類;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv.表示モード;
import jp.co.ndensan.reams.db.dbz.model.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 施設情報共有子Divのエンティティに対する操作を行うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShisetsuJohoHandler {

    private final ShisetsuJohoDiv div;

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
                div.getRadShisetsuShurui().setDataSource(createRad施設情報DataSource());
                div.getRadShisetsuShurui().setSelectedKey(ShisetsuType.介護保険施設.getCode());
                select施設種類();
                break;
            case 全施設対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.setMode_施設種類(施設種類.施設種類を表示する);
                div.getRadShisetsuShurui().setDataSource(createRad施設情報DataSource());
                div.getRadShisetsuShurui().setSelectedKey(ShisetsuType.介護保険施設.getCode());
                select施設種類();
                break;
            case 被保険者対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.getDdlDaichoShubetsu().setSelectedKey(DaichoType.被保険者.getCode());
                div.getRadShisetsuShurui().setDataSource(createRad施設情報DataSource());
                div.getRadShisetsuShurui().setSelectedKey(ShisetsuType.介護保険施設.getCode());
                select台帳種別();
                break;
            case 他市町村住所地特例者対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.getDdlDaichoShubetsu().setSelectedKey(DaichoType.他市町村住所地特例者.getCode());
                div.getRadShisetsuShurui().setDataSource(createRad施設情報DataSource());
                div.getRadShisetsuShurui().setSelectedKey(ShisetsuType.住所地特例対象施設.getCode());
                select台帳種別();
                break;
            case 適用除外者対象機能:
                div.setMode_台帳種別(台帳種別.台帳種別非表示する);
                div.getDdlDaichoShubetsu().setSelectedKey(DaichoType.適用除外者.getCode());
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

        if (selectedKey.equals(DaichoType.被保険者.getCode())) {
            div.getRadShisetsuShurui().setSelectedKey(ShisetsuType.介護保険施設.getCode());
            div.setMode_施設種類(施設種類.施設種類を表示する);
            div.setMode_入力補助(入力補助.事業者を表示する);

        } else if (selectedKey.equals(DaichoType.他市町村住所地特例者.getCode())) {
            div.getRadShisetsuShurui().setSelectedKey(ShisetsuType.住所地特例対象施設.getCode());
            div.setMode_施設種類(施設種類.施設種類を表示する);
            div.setMode_入力補助(入力補助.他特例施設を表示する);

        } else if (selectedKey.equals(DaichoType.適用除外者.getCode())) {
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

        if (selectedKey.equals(ShisetsuType.介護保険施設.getCode())) {
            div.setMode_入力補助(入力補助.事業者を表示する);

        } else if (selectedKey.equals(ShisetsuType.住所地特例対象施設.getCode())) {
            div.setMode_入力補助(入力補助.他特例施設を表示する);

        } else if (selectedKey.equals(ShisetsuType.適用除外施設.getCode())) {
            div.setMode_入力補助(入力補助.除外施設を表示する);

        }
    }

    /**
     * 台帳種別を返します。
     *
     * @return 台帳種別
     */
    public IOptional<DaichoType> get台帳種別() {
        try {
            return DbOptional.of(DaichoType.toValue(div.getDdlDaichoShubetsu().getSelectedKey()));
        } catch (IllegalArgumentException ex) {
            return DbOptional.empty();
        }
    }

    /**
     * 施設種類を返します。
     *
     * @return 施設種類
     */
    public ShisetsuType get施設種類() {
        switch (div.getMode_入力補助()) {
            case 事業者を表示する:
                return ShisetsuType.介護保険施設;
            case 他特例施設を表示する:
                return ShisetsuType.住所地特例対象施設;
            case 除外施設を表示する:
                return ShisetsuType.適用除外施設;
            default:
                throw new ApplicationException(DbzErrorMessages.選択されていない.getMessage().replace("施設種類").evaluate());
        }
    }

    /**
     * 施設コードを元に施設名称を取得します。
     */
    public void find施設名称() {
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

        List<KeyValueDataSource> list = new ArrayList<>();

        list.add(new KeyValueDataSource(DaichoType.被保険者.getCode(),
                DaichoType.被保険者.getName()));
        list.add(new KeyValueDataSource(DaichoType.他市町村住所地特例者.getCode(),
                DaichoType.他市町村住所地特例者.getName()));
        list.add(new KeyValueDataSource(DaichoType.適用除外者.getCode(),
                DaichoType.適用除外者.getName()));

        return list;
    }

    private List<KeyValueDataSource> createRad施設情報DataSource() {

        List<KeyValueDataSource> list = new ArrayList<>();

        list.add(new KeyValueDataSource(ShisetsuType.介護保険施設.getCode(),
                ShisetsuType.介護保険施設.getName()));
        list.add(new KeyValueDataSource(ShisetsuType.住所地特例対象施設.getCode(),
                ShisetsuType.住所地特例対象施設.getName()));
        if (div.getMode_利用機能() == 利用機能.全施設対象機能) {
            list.add(new KeyValueDataSource(ShisetsuType.適用除外施設.getCode(),
                    ShisetsuType.適用除外施設.getName()));
        }

        return list;
    }

}
