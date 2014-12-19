/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HowToEditJusho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 * {@link IHokensha IHokensha}の実装です。
 * {@link IHokensha IHokensha}のインスタンスを生成する{@link Hokensha.Builder}を持ちます。
 *
 * @author N3327 三浦 凌
 */
public final class Hokensha implements IHokensha {

    private final ShoKisaiHokenshaNo hokenshaNo;
    private final AtenaJusho jusho;
    private final YubinNo yubinNo;
    private final TelNo telNo;
    private final GunNamePrint gunNamePrint;
    private final TodofukenNamePrint todofukenNamePrint;
    private final ShichosonNamePrint shichosonNamePrint;
    private final KatagakiPrint katagakiPrint;
    private final HowToEditJusho howToEditJusho;

    private Hokensha(Builder builder) {
        this.hokenshaNo = builder.hokenshaNo;
        this.jusho = builder.jusho;
        this.yubinNo = builder.yubinNo;
        this.telNo = builder.telNo;
        this.gunNamePrint = builder.gunNamePrint;
        this.todofukenNamePrint = builder.todofukenNamePrint;
        this.shichosonNamePrint = builder.shichosonNamePrint;
        this.katagakiPrint = builder.katagakiPrint;
        this.howToEditJusho = builder.howToEditJusho;
    }

    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return this.hokenshaNo;
    }

    @Override
    public AtenaJusho get住所() {
        return this.jusho;
    }

    @Override
    public YubinNo get郵便番号() {
        return this.yubinNo;
    }

    @Override
    public TelNo get電話番号() {
        return this.telNo;
    }

    @Override
    public GunNamePrint get群名印字有無() {
        return this.gunNamePrint;
    }

    @Override
    public TodofukenNamePrint get都道府名印字有無() {
        return this.todofukenNamePrint;
    }

    @Override
    public ShichosonNamePrint get市町村名印字有無() {
        return this.shichosonNamePrint;
    }

    @Override
    public KatagakiPrint get方書印字有無() {
        return this.katagakiPrint;
    }

    @Override
    public HowToEditJusho get印字住所編集方法() {
        return this.howToEditJusho;
    }

    /**
     * {@link IHokensha}を生成します。
     */
    public static final class Builder {

        private final ShoKisaiHokenshaNo hokenshaNo;
        private AtenaJusho jusho = AtenaJusho.EMPTY;
        private YubinNo yubinNo = YubinNo.EMPTY;
        private TelNo telNo = TelNo.EMPTY;
        private GunNamePrint gunNamePrint = GunNamePrint.印字する;
        private TodofukenNamePrint todofukenNamePrint = TodofukenNamePrint.印字する;
        private ShichosonNamePrint shichosonNamePrint = ShichosonNamePrint.印字する;
        private KatagakiPrint katagakiPrint = KatagakiPrint.印字する;
        private HowToEditJusho howToEditJusho = HowToEditJusho.住所と番地;

        /**
         * {@link ShoKisaiHokenshaNo 証記載保険者番号}から、ビルダーを生成します。
         *
         * @param hokenshaNo {@link ShoKisaiHokenshaNo 証記載保険者番号}
         */
        public Builder(ShoKisaiHokenshaNo hokenshaNo) {
            this.hokenshaNo = hokenshaNo;
        }

        /**
         * {@link AtenaJusho 住所}を設定します。
         * このメソッドが使用されなかった場合、生成した{@link IHokenaha}は{@link AtenaJusho#EMPTY}を持ちます。
         *
         * @param jusho {@link AtenaJusho 住所}
         * @return {@link Builder}
         */
        public Builder jusho(AtenaJusho jusho) {
            this.jusho = jusho;
            return this;
        }

        /**
         * {@link YubinNo 郵便番号}を設定します。
         * このメソッドが使用されなかった場合、生成した{@link IHokenaha}は{@link YubinNo#EMPTY}を持ちます。
         *
         * @param yubinNo {@link YubinNo 郵便番号}
         * @return {@link Builder}
         */
        public Builder yubinNo(YubinNo yubinNo) {
            this.yubinNo = yubinNo;
            return this;
        }

        /**
         * {@link TelNo 電話番号}を設定します。
         * このメソッドが使用されなかった場合、生成した{@link IHokenaha}は{@link YubinNo#EMPTY}を持ちます。
         *
         * @param telNo {@link TelNo 電話番号}
         * @return {@link Builder}
         */
        public Builder telNo(TelNo telNo) {
            this.telNo = telNo;
            return this;
        }

        /**
         * {@link GunNamePrint 群名印字有無}を設定します。
         * このメソッドが使用されなかった場合、生成した{@link IHokenaha}は{@link GunNamePrint#印字する}を持ちます。
         *
         * @param gunNamePrint {@link GunNamePrint 群名印字有無}
         * @return {@link Builder}
         */
        public Builder gunNamePrint(GunNamePrint gunNamePrint) {
            this.gunNamePrint = gunNamePrint;
            return this;
        }

        /**
         * {@link TodofukenNamePrint 都道府県名印字有無}を設定します。
         * このメソッドが使用されなかった場合、生成した{@link IHokenaha}は{@link TodofukenNamePrint#印字する}を持ちます。
         *
         * @param todofukenNamePrint {@link TodofukenNamePrint 都道府県名印字有無}
         * @return {@link Builder}
         */
        public Builder todofukenNamePrint(TodofukenNamePrint todofukenNamePrint) {
            this.todofukenNamePrint = todofukenNamePrint;
            return this;
        }

        /**
         * {@link ShichosonNamePrint 市町村名印字有無}を設定します。
         * このメソッドが使用されなかった場合、生成した{@link IHokenaha}は{@link ShichosonNamePrint#印字する}を持ちます。
         *
         * @param shichosonNamePrint {@link ShichosonNamePrint 市町村名印字有無}
         * @return {@link Builder}
         */
        public Builder shichosonNamePrint(ShichosonNamePrint shichosonNamePrint) {
            this.shichosonNamePrint = shichosonNamePrint;
            return this;
        }

        /**
         * {@link KatagakiPrint 方書印字有無}を設定します。
         * このメソッドが使用されなかった場合、生成した{@link IHokenaha}は{@link KatagakiPrint#印字する}を持ちます。
         *
         * @param katagakiPrint {@link KatagakiPrint 方書印字有無}
         * @return {@link Builder}
         */
        public Builder katagakiPrint(KatagakiPrint katagakiPrint) {
            this.katagakiPrint = katagakiPrint;
            return this;
        }

        /**
         * {@link HowToEditJusho 住所編集方法}を設定します。
         *
         * @param howToEditJusho {@link HowToEditJusho 住所編集方法}
         * @return {@link Builder}
         */
        public Builder howToEditJusho(HowToEditJusho howToEditJusho) {
            this.howToEditJusho = howToEditJusho;
            return this;
        }

        /**
         * {@link IHokensha}を生成します。
         *
         * @return {@link IHokensha}
         */
        public IHokensha build() {
            return new Hokensha(this);
        }
    }
}
