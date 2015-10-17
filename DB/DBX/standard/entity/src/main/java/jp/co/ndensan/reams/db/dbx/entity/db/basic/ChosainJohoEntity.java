/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnRshareSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 調査員情報エンティティです。
 *
 * @author N2204 三井 沙織
 * @jpName 調査員情報エンティティ
 * @bizDomain 介護
 * @category 認定調査員
 * @subCategory
 * @mainClass
 * @reference
 */
@OnRshareSchema
public class ChosainJohoEntity implements IDbAccessable {

    // TODO n2204三井沙織 マスタ定義が決まったらこのクラスをDBに合わせる 2013/12/31
    @TableName
    public static final RString TABLE_NAME = new RString("T7013ChosainJoho");
    @PrimaryKey
    private RString 市町村コード;
    @PrimaryKey
    private KaigoJigyoshaNo 介護事業者番号;
    @PrimaryKey
    private RString 介護調査員番号;
    private RString 事業者番号;
    private RString 介護調査員状況;
    private RString 調査員氏名;
    private RString 調査員氏名カナ;
    private Gender 性別;
    private RString 調査員資格;
    private RString 地区コード;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public RString get市町村コード() {
        return 市町村コード;
    }

    /**
     * 介護事業者番号を返します。
     *
     * @return 介護事業者番号
     */
    public KaigoJigyoshaNo get介護事業者番号() {
        return 介護事業者番号;
    }

    /**
     * 介護調査員番号を返します。
     *
     * @return 介護調査員番号
     */
    public RString get介護調査員番号() {
        return 介護調査員番号;
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public RString get事業者番号() {
        return 事業者番号;
    }

    /**
     * 介護調査員状況を返します。
     *
     * @return 介護調査員状況
     */
    public RString get介護調査員状況() {
        return 介護調査員状況;
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return 調査員氏名;
    }

    /**
     * 調査員氏名カナを返します。
     *
     * @return 調査員氏名カナ
     */
    public RString get調査員氏名カナ() {
        return 調査員氏名カナ;
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Gender get性別() {
        return 性別;
    }

    /**
     * 調査員資格を返します。
     *
     * @return 調査員資格
     */
    public RString get調査員資格() {
        return 調査員資格;
    }

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    public RString get地区コード() {
        return 地区コード;
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return 郵便番号;
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        return 住所;
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public RString get電話番号() {
        return 電話番号;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(RString 市町村コード) {
        this.市町村コード = 市町村コード;
    }

    /**
     * 介護事業者番号を設定します。
     *
     * @param 介護事業者番号 介護事業者番号
     */
    public void set介護事業者番号(KaigoJigyoshaNo 介護事業者番号) {
        this.介護事業者番号 = 介護事業者番号;
    }

    /**
     * 介護調査員番号を設定します。
     *
     * @param 介護調査員番号 介護調査員番号
     */
    public void set介護調査員番号(RString 介護調査員番号) {
        this.介護調査員番号 = 介護調査員番号;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     */
    public void set事業者番号(RString 事業者番号) {
        this.事業者番号 = 事業者番号;
    }

    /**
     * 介護調査員状況を設定します。
     *
     * @param 介護調査員状況 介護調査員状況
     */
    public void set介護調査員状況(RString 介護調査員状況) {
        this.介護調査員状況 = 介護調査員状況;
    }

    /**
     * 調査員氏名を設定します。
     *
     * @param 調査員氏名 調査員氏名
     */
    public void set調査員氏名(RString 調査員氏名) {
        this.調査員氏名 = 調査員氏名;
    }

    /**
     * 調査員氏名カナを設定します。
     *
     * @param 調査員氏名カナ 調査員氏名カナ
     */
    public void set調査員氏名カナ(RString 調査員氏名カナ) {
        this.調査員氏名カナ = 調査員氏名カナ;
    }

    /**
     * 性別を設定します。
     *
     * @param 性別 性別
     */
    public void set性別(Gender 性別) {
        this.性別 = 性別;
    }

    /**
     * 調査員資格を設定します。
     *
     * @param 調査員資格 調査員資格
     */
    public void set調査員資格(RString 調査員資格) {
        this.調査員資格 = 調査員資格;
    }

    /**
     * 地区コードを設定します。
     *
     * @param 地区コード 地区コード
     */
    public void set地区コード(RString 地区コード) {
        this.地区コード = 地区コード;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     */
    public void set郵便番号(RString 郵便番号) {
        this.郵便番号 = 郵便番号;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     */
    public void set住所(RString 住所) {
        this.住所 = 住所;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     */
    public void set電話番号(RString 電話番号) {
        this.電話番号 = 電話番号;
    }
}
