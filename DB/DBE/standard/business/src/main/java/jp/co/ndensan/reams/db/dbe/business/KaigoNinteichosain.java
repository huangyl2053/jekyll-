/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosainJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 * 介護認定調査員の情報を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KaigoNinteichosain {

    private final LasdecCode 市町村コード;
    private final KaigoJigyoshaNo 介護事業者番号;
    private final KaigoNinteichosainNo 介護調査員番号;
    private final ChosainJokyo 調査員状況;
    private final AtenaMeisho 調査員氏名;
    private final AtenaKanaMeisho 調査員氏名カナ;
    private final Gender 性別;
    // TODO N8187 久保田英男 調査員資格コードはコードマスタで管理する項目なのでクラス化する予定 実装方針が決まったら対応する。
    private final Code 調査員資格コード;
    private final ChikuCode 地区コード;
    private final YubinNo 郵便番号;
    private final AtenaJusho 住所;
    private final TelNo 電話番号;
    private final NinteichosaItakusaki 認定調査委託先;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護調査員番号 介護調査員番号
     * @param 調査員状況 調査員状況
     * @param 調査員氏名 調査員氏名
     * @param 調査員氏名カナ 調査員氏名カナ
     * @param 性別 性別
     * @param 調査員資格コード 調査員資格コード
     * @param 地区コード 地区コード
     * @param 郵便番号 郵便番号
     * @param 住所 住所
     * @param 電話番号 電話番号
     * @param 認定調査委託先 認定調査委託先
     * @throws NullPointerException 調査員状況および性別以外の引数にNULLが渡された場合
     */
    public KaigoNinteichosain(LasdecCode 市町村コード,
            KaigoJigyoshaNo 介護事業者番号,
            KaigoNinteichosainNo 介護調査員番号,
            ChosainJokyo 調査員状況,
            AtenaMeisho 調査員氏名,
            AtenaKanaMeisho 調査員氏名カナ,
            Gender 性別,
            Code 調査員資格コード,
            ChikuCode 地区コード,
            YubinNo 郵便番号,
            AtenaJusho 住所,
            TelNo 電話番号,
            NinteichosaItakusaki 認定調査委託先) throws NullPointerException {

        this.市町村コード = requireNonNull(市町村コード, Messages.E00001.replace("市町村コード").getMessage());
        this.介護事業者番号 = requireNonNull(介護事業者番号, Messages.E00001.replace("介護事業者番号").getMessage());
        this.介護調査員番号 = requireNonNull(介護調査員番号, Messages.E00001.replace("介護調査員番号").getMessage());
        this.調査員状況 = 調査員状況;
        this.調査員氏名 = requireNonNull(調査員氏名, Messages.E00001.replace("調査員氏名").getMessage());
        this.調査員氏名カナ = requireNonNull(調査員氏名カナ, Messages.E00001.replace("調査員氏名カナ").getMessage());
        this.性別 = 性別;
        this.調査員資格コード = requireNonNull(調査員資格コード, Messages.E00001.replace("調査員資格コード").getMessage());
        this.地区コード = requireNonNull(地区コード, Messages.E00001.replace("地区コード").getMessage());
        this.郵便番号 = requireNonNull(郵便番号, Messages.E00001.replace("郵便番号").getMessage());
        this.住所 = requireNonNull(住所, Messages.E00001.replace("住所").getMessage());
        this.電話番号 = requireNonNull(電話番号, Messages.E00001.replace("電話番号").getMessage());
        this.認定調査委託先 = requireNonNull(認定調査委託先, Messages.E00001.replace("認定調査委託先").getMessage());
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
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
    public KaigoNinteichosainNo get介護調査員番号() {
        return 介護調査員番号;
    }

    /**
     * 調査員状況を返します。
     *
     * @return 調査員状況
     */
    public ChosainJokyo get調査員状況() {
        return 調査員状況;
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public AtenaMeisho get調査員氏名() {
        return 調査員氏名;
    }

    /**
     * 調査員氏名カナを返します。
     *
     * @return 調査員氏名カナ
     */
    public AtenaKanaMeisho get調査員氏名カナ() {
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
     * 調査員資格コードを返します。
     *
     * @return 調査員資格コード
     */
    public Code get調査員資格コード() {
        return 調査員資格コード;
    }

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    public ChikuCode get地区コード() {
        return 地区コード;
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return 郵便番号;
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return 住所;
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return 電話番号;
    }

    /**
     * 認定調査委託先を返します。
     *
     * @return 認定調査委託先
     */
    public NinteichosaItakusaki get認定調査委託先() {
        return 認定調査委託先;
    }
}
