/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 認定調査依頼情報のエンティティクラスです
 *
 * @author N8187 久保田 英男
 */
public class DbT5006NinteichosaIraiJohoEntity implements IDbAccessable {

    /**
     * 認定調査依頼情報テーブル
     */
    @TableName
    public static final RString TABLE_NAME = new RString("T5006NinteichosaIraiJoho");
    @PrimaryKey
    private ShinseishoKanriNo 申請書管理番号;
    @PrimaryKey
    private RString 認定調査依頼履歴番号;
    private RString 認定調査委託先コード;
    private RString 調査員番号コード;
    private RString 認定調査依頼区分コード;
    private int 認定調査回数;
    private FlexibleDate 認定調査依頼年月日;
    private FlexibleDate 認定調査期限年月日;
    private FlexibleDate 依頼書出力年月日;
    private FlexibleDate 調査票等出力年月日;
    private boolean モバイルデータ出力フラグ;
    private FlexibleDate 認定調査督促年月日;
    private RString 認定調査督促方法;
    private int 認定調査督促回数;
    private RString 認定調査督促メモ;

    /**
     * ORマッパーのためのデフォルトコンストラクタです。
     */
    DbT5006NinteichosaIraiJohoEntity() {
    }

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 調査員番号コード 調査員番号コード
     * @param 認定調査依頼区分コード 認定調査依頼区分コード
     * @param 認定調査回数 認定調査回数
     * @param 認定調査依頼年月日 認定調査依頼年月日
     * @param 認定調査期限年月日 認定調査期限年月日
     * @param 依頼書出力年月日 依頼書出力年月日
     * @param 調査票等出力年月日 調査票等出力年月日
     * @param モバイルデータ出力フラグ モバイルデータ出力フラグ
     * @param 認定調査督促年月日 認定調査督促年月日
     * @param 認定調査督促方法 認定調査督促方法
     * @param 認定調査督促回数 認定調査督促回数
     * @param 認定調査督促メモ 認定調査督促メモ
     */
    public DbT5006NinteichosaIraiJohoEntity(
            ShinseishoKanriNo 申請書管理番号,
            RString 認定調査依頼履歴番号,
            RString 認定調査委託先コード,
            RString 調査員番号コード,
            RString 認定調査依頼区分コード,
            int 認定調査回数,
            FlexibleDate 認定調査依頼年月日,
            FlexibleDate 認定調査期限年月日,
            FlexibleDate 依頼書出力年月日,
            FlexibleDate 調査票等出力年月日,
            boolean モバイルデータ出力フラグ,
            FlexibleDate 認定調査督促年月日,
            RString 認定調査督促方法,
            int 認定調査督促回数,
            RString 認定調査督促メモ) {
        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        this.認定調査委託先コード = 認定調査委託先コード;
        this.調査員番号コード = 調査員番号コード;
        this.認定調査依頼区分コード = 認定調査依頼区分コード;
        this.認定調査回数 = 認定調査回数;
        this.認定調査依頼年月日 = 認定調査依頼年月日;
        this.認定調査期限年月日 = 認定調査期限年月日;
        this.依頼書出力年月日 = 依頼書出力年月日;
        this.調査票等出力年月日 = 調査票等出力年月日;
        this.モバイルデータ出力フラグ = モバイルデータ出力フラグ;
        this.認定調査督促年月日 = 認定調査督促年月日;
        this.認定調査督促方法 = 認定調査督促方法;
        this.認定調査督促回数 = 認定調査督促回数;
        this.認定調査督促メモ = 認定調査督促メモ;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 申請書管理番号;
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public RString get認定調査依頼履歴番号() {
        return 認定調査依頼履歴番号;
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return 認定調査委託先コード;
    }

    /**
     * 調査員番号コードを返します。
     *
     * @return 調査員番号コード
     */
    public RString get調査員番号コード() {
        return 調査員番号コード;
    }

    /**
     * 認定調査依頼区分コードを返します。
     *
     * @return 認定調査依頼区分コード
     */
    public RString get認定調査依頼区分コード() {
        return 認定調査依頼区分コード;
    }

    /**
     * 認定調査回数を返します。
     *
     * @return 認定調査回数
     */
    public int get認定調査回数() {
        return 認定調査回数;
    }

    /**
     * 認定調査依頼年月日を返します。
     *
     * @return 認定調査依頼年月日
     */
    public FlexibleDate get認定調査依頼年月日() {
        return 認定調査依頼年月日;
    }

    /**
     * 認定調査期限年月日を返します。
     *
     * @return 認定調査期限年月日
     */
    public FlexibleDate get認定調査期限年月日() {
        return 認定調査期限年月日;
    }

    /**
     * 依頼書出力年月日を返します。
     *
     * @return 依頼書出力年月日
     */
    public FlexibleDate get依頼書出力年月日() {
        return 依頼書出力年月日;
    }

    /**
     * 調査票等出力年月日を返します。
     *
     * @return 調査票等出力年月日
     */
    public FlexibleDate get調査票等出力年月日() {
        return 調査票等出力年月日;
    }

    /**
     * モバイルデータ出力フラグを返します。
     *
     * @return モバイルデータ出力フラグ
     */
    public boolean isモバイルデータ出力フラグ() {
        return モバイルデータ出力フラグ;
    }

    /**
     * 認定調査督促年月日を返します。
     *
     * @return 認定調査督促年月日
     */
    public FlexibleDate get認定調査督促年月日() {
        return 認定調査督促年月日;
    }

    /**
     * 認定調査督促方法を返します。
     *
     * @return 認定調査督促方法
     */
    public RString get認定調査督促方法() {
        return 認定調査督促方法;
    }

    /**
     * 認定調査督促回数を返します。
     *
     * @return 認定調査督促回数
     */
    public int get認定調査督促回数() {
        return 認定調査督促回数;
    }

    /**
     * 認定調査督促メモを返します。
     *
     * @return 認定調査督促メモ
     */
    public RString get認定調査督促メモ() {
        return 認定調査督促メモ;
    }
}
