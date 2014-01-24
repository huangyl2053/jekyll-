/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 認定調査委託先のエンティティクラスです
 *
 * @author N1013 松本直樹
 */
public class DbT7010NinteichosaItakusakiJohoEntity implements IDbAccessable {
//TODO 市町村コードはILocalGovernmentCodeを使用するか検討する。 2014/02/14 期限

    /**
     * 認定調査委託先テーブル
     */
    @TableName
    public static final RString TABLE_NAME = new RString("T7010NinteichosaItakusakiJoho");
    @PrimaryKey
    private RString 市町村コード;
    @PrimaryKey
    private KaigoJigyoshaNo 介護事業者番号;
    private JigyoshaNo 事業者番号;
    private boolean 介護事業者状況;
    private ChosaItakuKubun 調査委託区分;
    private int 割付定員;
    private RString 割付地区;
    private RString 機関の区分;

    /**
     * ORマッパーのためのデフォルトコンストラクタです。
     */
    DbT7010NinteichosaItakusakiJohoEntity() {
    }

    /**
     * コンストラクタクラスです
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 事業者番号 事業者番号
     * @param 介護事業者状況 介護事業者状況
     * @param 調査委託区分 調査委託区分
     * @param 割付定員 割付定員
     * @param 割付地区 割付地区
     * @param 機関の区分 機関の区分
     */
    public DbT7010NinteichosaItakusakiJohoEntity(RString 市町村コード, KaigoJigyoshaNo 介護事業者番号,
            JigyoshaNo 事業者番号, boolean 介護事業者状況, ChosaItakuKubun 調査委託区分,
            int 割付定員, RString 割付地区, RString 機関の区分) {
        this.市町村コード = 市町村コード;
        this.介護事業者番号 = 介護事業者番号;
        this.事業者番号 = 事業者番号;
        this.介護事業者状況 = 介護事業者状況;
        this.調査委託区分 = 調査委託区分;
        this.割付定員 = 割付定員;
        this.割付地区 = 割付地区;
        this.機関の区分 = 機関の区分;

    }

    /**
     * 認定調査委託先クラスからのコンストラクタです
     *
     * @param 認定調査委託先 認定調査委託先
     */
    public DbT7010NinteichosaItakusakiJohoEntity(NinteichosaItakusaki 認定調査委託先) {
        this.市町村コード = 認定調査委託先.get市町村コード();
        this.介護事業者番号 = 認定調査委託先.getKaigoJigyoshaNo();
        this.事業者番号 = 認定調査委託先.getJigyoshaNo();
        this.介護事業者状況 = 認定調査委託先.is有効();
        this.調査委託区分 = 認定調査委託先.getChosaItakuKubun();
        this.割付定員 = 認定調査委託先.getWaritsukeTeiin();
        this.割付地区 = 認定調査委託先.getWaritsukeChiku();
        this.機関の区分 = 認定調査委託先.getKikanKubun();

    }

    /**
     * 市町村コードを返します
     *
     * @return 市町村コード
     */
    public RString get市町村コード() {
        return 市町村コード;
    }

    /**
     * 介護事業者番号を返します
     *
     * @return 介護事業者番号
     */
    public KaigoJigyoshaNo get介護事業者番号() {
        return 介護事業者番号;
    }

    /**
     * 事業者番号を返します
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return 事業者番号;
    }

    /**
     * 介護事業者状況を返します
     *
     * @return 介護事業者状況
     */
    public boolean is介護事業者状況() {
        return 介護事業者状況;
    }

    /**
     * 調査委託区分を返します
     *
     * @return 調査委託区分
     */
    public ChosaItakuKubun get調査委託区分() {
        return 調査委託区分;
    }

    /**
     * 割付定員を返します
     *
     * @return 割付定員
     */
    public int get割付定員() {
        return 割付定員;
    }

    /**
     * 割付地区を返します
     *
     * @return 割付地区
     */
    public RString get割付地区() {
        return 割付地区;
    }

    /**
     * 機関の区分を返します
     *
     * @return 機関の区分
     */
    public RString get機関の区分() {
        return 機関の区分;
    }

    /**
     * 市町村コードを設定します
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(RString 市町村コード) {
        this.市町村コード = 市町村コード;
    }

    /**
     * 介護事業者番号を設定します
     *
     * @param 介護事業者番号 介護事業者番号
     */
    public void set介護事業者番号(KaigoJigyoshaNo 介護事業者番号) {
        this.介護事業者番号 = 介護事業者番号;

    }

    /**
     * 事業者番号を設定します
     *
     * @param 事業者番号 事業者番号
     */
    public void set事業者番号(JigyoshaNo 事業者番号) {
        this.事業者番号 = 事業者番号;
    }

    /**
     * 介護事業者状況を設定します
     *
     * @param 介護事業者状況 介護事業者状況
     */
    public void set介護事業者状況(boolean 介護事業者状況) {
        this.介護事業者状況 = 介護事業者状況;
    }

    /**
     * 調査委託区分を設定します
     *
     * @param 調査委託区分 調査委託区分
     */
    public void set調査委託区分(ChosaItakuKubun 調査委託区分) {
        this.調査委託区分 = 調査委託区分;
    }

    /**
     * 割付定員を設定します
     *
     * @param 割付定員 割付定員
     */
    public void set割付定員(int 割付定員) {
        this.割付定員 = 割付定員;
    }

    /**
     * 割付地区を設定します
     *
     * @param 割付地区 割付地区
     */
    public void set割付地区(RString 割付地区) {
        this.割付地区 = 割付地区;
    }

    /**
     * 機関の区分を設定します
     *
     * @param 機関の区分 機関の区分
     */
    public void set機関の区分(RString 機関の区分) {
        this.機関の区分 = 機関の区分;
    }
}
