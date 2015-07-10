/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7024KoikiShichosonCodeHenkanPatternEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域市町村管理コード変換パターンエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator {

    public static final RString DEFAULT_広域内市町村番号 = new RString("45");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_コード区分 = new RString("1");
    public static final RString DEFAULT_コード変換テーブル使用区分 = new RString("1");
    public static final RString DEFAULT_自動採番区分 = new RString("3");
    public static final int DEFAULT_市町村用コード桁数 = 1;
    public static final int DEFAULT_市町村用コード開始位置 = 1;
    public static final int DEFAULT_市町村用コード使用桁数 = 1;
    public static final RString DEFAULT_市町村用チェックディジット有無区分 = new RString("1");
    public static final int DEFAULT_広域用コード桁数 = 1;
    public static final int DEFAULT_広域用コード開始位置 = 1;
    public static final int DEFAULT_広域用コード使用桁数 = 1;
    public static final RString DEFAULT_広域用チェックディジット有無区分 = new RString("1");
    public static final RString DEFAULT_広域内市町村番号付加区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator() {
    }

    public static DbT7024KoikiShichosonCodeHenkanPatternEntity createDbT7024KoikiShichosonCodeHenkanPatternEntity() {
        DbT7024KoikiShichosonCodeHenkanPatternEntity entity = new DbT7024KoikiShichosonCodeHenkanPatternEntity();
        entity.setKoikiShichosonNo(DEFAULT_広域内市町村番号);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setCodeKubun(DEFAULT_コード区分);
        entity.setCodeHenkanTableShiyoUmu(DEFAULT_コード変換テーブル使用区分);
        entity.setJidoSaibanKubun(DEFAULT_自動採番区分);
        entity.setShichosonCodeKetasu(DEFAULT_市町村用コード桁数);
        entity.setShichosonCodeKaishiIchi(DEFAULT_市町村用コード開始位置);
        entity.setShichosonCodeShiyoKetasu(DEFAULT_市町村用コード使用桁数);
        entity.setShichosonNinshoNoUmu(DEFAULT_市町村用チェックディジット有無区分);
        entity.setKoikiCodeKetasu(DEFAULT_広域用コード桁数);
        entity.setKoikiCodeKaishiIchi(DEFAULT_広域用コード開始位置);
        entity.setKoikiCodeShiyoKetasu(DEFAULT_広域用コード使用桁数);
        entity.setKoikiNinshoNoUmu(DEFAULT_広域用チェックディジット有無区分);
        entity.setShichosonNoFukaKubun(DEFAULT_広域内市町村番号付加区分);
        return entity;
    }
}
