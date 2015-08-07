/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 国保連インターフェース管理エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3104KokuhorenInterfaceKanriEntityGenerator {

    public static final FlexibleYearMonth DEFAULT_処理年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_交換情報識別番号 = new RString("Data");
    public static final RString DEFAULT_送付取込区分 = new RString("Data");
    public static final RString DEFAULT_処理状態区分 = new RString("Data");
    public static final YMDHMS DEFAULT_処理実施日時 = new YMDHMS("19901101120532");;
    public static final YMDHMS DEFAULT_抽出開始日時 = new YMDHMS("19901101120532");;
    public static final YMDHMS DEFAULT_抽出終了日時 = new YMDHMS("19901101120532");;
    public static final boolean DEFAULT_再処理可能区分 = false;
    public static final Decimal DEFAULT_処理実行回数 = new Decimal(0);
    public static final RString DEFAULT_ファイル名称１ = new RString("Data");
    public static final RString DEFAULT_ファイル名称２ = new RString("Data");
    public static final RString DEFAULT_ファイル名称３ = new RString("Data");
    public static final RString DEFAULT_ファイル名称４ = new RString("Data");
    public static final RString DEFAULT_ファイル名称５ = new RString("Data");
    public static final int DEFAULT_ファイル件数１ = 1;
    public static final int DEFAULT_ファイル件数２ = 1;
    public static final int DEFAULT_ファイル件数３ = 1;
    public static final int DEFAULT_ファイル件数４ = 1;
    public static final int DEFAULT_ファイル件数５ = 1;
    public static final boolean DEFAULT_再処理設定不可区分 = false;
    public static final int DEFAULT_コントロール上レコード件数 = 1;
    public static final FlexibleYearMonth DEFAULT_コントロール上処理年月 = new FlexibleYear("1990");
    public static final int DEFAULT_過誤コントロール上レコード件数 = 1;
    public static final FlexibleYearMonth DEFAULT_過誤コントロール上処理年月 = new FlexibleYear("1990");
    public static final FlexibleYearMonth DEFAULT_実績データ上審査年月 = new FlexibleYear("1990");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3104KokuhorenInterfaceKanriEntityGenerator() {
    }

    public static DbT3104KokuhorenInterfaceKanriEntity createDbT3104KokuhorenInterfaceKanriEntity() {
        DbT3104KokuhorenInterfaceKanriEntity entity = new DbT3104KokuhorenInterfaceKanriEntity();
        entity.setShoriYM(DEFAULT_処理年月);
        entity.setKokanShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setSofuTorikomiKubun(DEFAULT_送付取込区分);
        entity.setShoriJotaiKubun(DEFAULT_処理状態区分);
        entity.setShoriJisshiTimestamp(DEFAULT_処理実施日時);
        entity.setChushutsuKaishiTimestamp(DEFAULT_抽出開始日時);
        entity.setChushutsuShuryoTimestamp(DEFAULT_抽出終了日時);
        entity.setSaiShoriKahiKubun(DEFAULT_再処理可能区分);
        entity.setShoriJikkoKaisu(DEFAULT_処理実行回数);
        entity.setFileName1(DEFAULT_ファイル名称１);
        entity.setFileName2(DEFAULT_ファイル名称２);
        entity.setFileName3(DEFAULT_ファイル名称３);
        entity.setFileName4(DEFAULT_ファイル名称４);
        entity.setFileName5(DEFAULT_ファイル名称５);
        entity.setFileKensu1(DEFAULT_ファイル件数１);
        entity.setFileKensu2(DEFAULT_ファイル件数２);
        entity.setFileKensu3(DEFAULT_ファイル件数３);
        entity.setFileKensu4(DEFAULT_ファイル件数４);
        entity.setFileKensu5(DEFAULT_ファイル件数５);
        entity.setSaiShoriFukaKubun(DEFAULT_再処理設定不可区分);
        entity.setCtrlRecordKensu(DEFAULT_コントロール上レコード件数);
        entity.setCtrlShoriYM(DEFAULT_コントロール上処理年月);
        entity.setKagoCtrlRecordKensu(DEFAULT_過誤コントロール上レコード件数);
        entity.setKagoCtrlShoriYM(DEFAULT_過誤コントロール上処理年月);
        entity.setJissekiDataShinsaYM(DEFAULT_実績データ上審査年月);
        return entity;
    }
}
