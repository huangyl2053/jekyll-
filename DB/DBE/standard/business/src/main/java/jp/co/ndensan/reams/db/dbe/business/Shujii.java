/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IYubinNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.IJusho;
import static java.util.Objects.requireNonNull;

/**
 * 主治医の情報を表すクラスです。
 *
 * @author N8156 宮本 康
 */
public class Shujii implements IShujii {

    private final ShichosonCode 市町村コード;
    private final KaigoIryoKikanCode 介護医療機関コード;
    private final KaigoDoctorCode 介護医師コード;
    private final IIryoKikanCode 医療機関コード;
    private final RString 医師識別番号;
    private final IshiJokyo 医師の状況;
    private final IYubinNo 郵便番号;
    private final IJusho 住所;
    private final RString 電話番号;
    private final RString FAX番号;

    /**
     * インスタンスを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @param 介護医師コード 介護医師コード
     * @param 医療機関コード 医療機関コード
     * @param 医師識別番号 医師識別番号
     * @param 医師の状況 医師の状況
     * @param 郵便番号 郵便番号
     * @param 住所 住所
     * @param 電話番号 電話番号
     * @param FAX番号 FAX番号
     */
    public Shujii(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード,
            IIryoKikanCode 医療機関コード, RString 医師識別番号, IshiJokyo 医師の状況,
            IYubinNo 郵便番号, IJusho 住所, RString 電話番号, RString FAX番号) {
        this.市町村コード = requireNonNull(市町村コード, Messages.E00001.replace("麻痺左上肢").getMessage());
        this.介護医療機関コード = requireNonNull(介護医療機関コード, Messages.E00001.replace("麻痺左上肢").getMessage());
        this.介護医師コード = requireNonNull(介護医師コード, Messages.E00001.replace("麻痺左上肢").getMessage());
        this.医療機関コード = requireNonNull(医療機関コード, Messages.E00001.replace("麻痺左上肢").getMessage());
        this.医師識別番号 = requireNonNull(医師識別番号, Messages.E00001.replace("麻痺左上肢").getMessage());
        this.医師の状況 = requireNonNull(医師の状況, Messages.E00001.replace("麻痺左上肢").getMessage());
        this.郵便番号 = 郵便番号;
        this.住所 = 住所;
        this.電話番号 = 電話番号;
        this.FAX番号 = FAX番号;
    }

    @Override
    public ShichosonCode get市町村コード() {
        return 市町村コード;
    }

    @Override
    public KaigoIryoKikanCode get介護医療機関コード() {
        return 介護医療機関コード;
    }

    @Override
    public KaigoDoctorCode get介護医師コード() {
        return 介護医師コード;
    }

    @Override
    public IIryoKikanCode get医療機関コード() {
        return 医療機関コード;
    }

    @Override
    public RString get医師識別番号() {
        return 医師識別番号;
    }

    @Override
    public boolean is有効() {
        return 医師の状況.is有効();
    }

    @Override
    public IYubinNo get郵便番号() {
        return 郵便番号;
    }

    @Override
    public IJusho get住所() {
        return 住所;
    }

    @Override
    public RString get電話番号() {
        return 電話番号;
    }

    @Override
    public RString getFAX番号() {
        return FAX番号;
    }
}
