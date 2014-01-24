/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 発番管理情報のエンティティクラスです
 *
 * @author N1013 松本直樹
 */
public class DbT5020HatsubanKanriJohoEntity implements IDbAccessable {
//TODO 介護事業者番号の発番については、発番管理は共通の発番クラスを利用するか検討する　2014/02/28期限

    /**
     * 発番管理情報テーブル
     */
    @TableName
    public static final RString TABLE_NAME = new RString("T5020HatsubanKanriJoho");
    @PrimaryKey
    private RString 項目区分;
    @PrimaryKey
    private RString 年度;
    private RString 発番;

    /**
     * ORマッパーのためのデフォルトコンストラクタです。
     */
    DbT5020HatsubanKanriJohoEntity() {
    }

    /**
     * コンストラクタクラスです
     *
     * @param 項目区分
     * @param 年度
     * @param 発番
     */
    public DbT5020HatsubanKanriJohoEntity(RString 項目区分, RString 年度, RString 発番) {
        this.項目区分 = 項目区分;
        this.年度 = 年度;
        this.発番 = 発番;
    }

    /**
     * 項目区分を返します
     *
     * @return
     */
    public RString get項目区分() {
        return 項目区分;
    }

    /**
     * 年度を返します
     *
     * @return
     */
    public RString get年度() {
        return 年度;
    }

    /**
     * 発番を返します
     *
     * @return
     */
    public RString get発番() {
        return 発番;
    }

    /**
     * 項目区分を設定します
     *
     * @param 項目区分
     */
    public void set項目区分(RString 項目区分) {
        this.項目区分 = 項目区分;
    }

    /**
     * 年度を設定します
     *
     * @param 年度
     */
    public void set年度(RString 年度) {
        this.年度 = 年度;
    }

    /**
     * 発番情報を設定します
     *
     * @param 発番
     */
    public void set発番(RString 発番) {
        this.発番 = 発番;
    }
}
