/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連取り込み情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbV3104KokuhorenTorikomiJohoEntityGenerator {

    public static final FlexibleYearMonth DEFAULT_処理年月 = new FlexibleYearMonth("199010");
    public static final RString DEFAULT_交換情報識別番号 = new RString("Data");
    public static final RString DEFAULT_処理状態区分 = new RString("Data");
    public static final RString DEFAULT_前_処理状態区分 = new RString("Data");
    public static final RString DEFAULT_前々_処理状態区分 = new RString("Data");
    public static final YMDHMS DEFAULT_処理実施日時 = new YMDHMS("19901101120532");
    ;
    public static final boolean DEFAULT_再処理可能区分 = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbV3104KokuhorenTorikomiJohoEntityGenerator() {
    }

    public static DbV3104KokuhorenTorikomiJohoEntity createDbV3104KokuhorenTorikomiJohoEntity() {
        DbV3104KokuhorenTorikomiJohoEntity entity = new DbV3104KokuhorenTorikomiJohoEntity();
        entity.setShoriYM(DEFAULT_処理年月);
        entity.setKokanShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setShoriJotaiKubun(DEFAULT_処理状態区分);
        entity.setZen_shorijotaikubun(DEFAULT_前_処理状態区分);
        entity.setZenzen_shorijotaikubun(DEFAULT_前々_処理状態区分);
        entity.setTougetsushoridate(DEFAULT_処理実施日時);
        entity.setSaiShoriKanoKubun(DEFAULT_再処理可能区分);
        return entity;
    }
}
