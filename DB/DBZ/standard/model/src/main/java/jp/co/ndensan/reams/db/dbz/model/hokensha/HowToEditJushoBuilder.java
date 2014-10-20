/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hokensha;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushoEditPattern;

/**
 * {@link IHowToEditJusho IHowToEditJusho}を生成します。
 *
 * @author N3327 三浦 凌
 */
public class HowToEditJushoBuilder {

    private GunNamePrint gun = GunNamePrint.印字する;
    private TodofukenNamePrint todofuken = TodofukenNamePrint.印字する;
    private ShichosonNamePrint shichoson = ShichosonNamePrint.印字する;
    private KatagakiPrint katagaki = KatagakiPrint.印字する;
    private JushoEditPattern jusho = JushoEditPattern.行政区番地;

    public HowToEditJushoBuilder() {
    }

    /**
     * 群名の編集方法を設定します。
     *
     * @param g 群名の編集方法
     * @return this
     */
    public HowToEditJushoBuilder set群名編集方法(GunNamePrint g) {
        this.gun = Objects.requireNonNull(g);
        return this;
    }

    public HowToEditJushoBuilder set都道府県名編集方法(TodofukenNamePrint t) {
        this.todofuken = Objects.requireNonNull(t);
        return this;
    }

    public HowToEditJushoBuilder set市町村名編集方法(ShichosonNamePrint s) {
        this.shichoson = Objects.requireNonNull(s);
        return this;
    }

    public HowToEditJushoBuilder set方書編集方法(KatagakiPrint k) {
        this.katagaki = Objects.requireNonNull(k);
        return this;
    }

    public HowToEditJushoBuilder set住所編集方法(JushoEditPattern j) {
        this.jusho = Objects.requireNonNull(j);
        return this;
    }

    /**
     * {@link IHowToEditJusho IHowToEditJusho}を生成します。
     *
     * @return {@link IHowToEditJusho IHowToEditJusho}
     */
    public IHowToEditJusho build() {
        return new _HowToEditJusho(gun, todofuken, shichoson, katagaki, jusho);
    }

    private static final class _HowToEditJusho implements IHowToEditJusho {

        private final GunNamePrint gun;
        private final TodofukenNamePrint todofuken;
        private final ShichosonNamePrint shichoson;
        private final KatagakiPrint katagaki;
        private final JushoEditPattern jusho;

        private _HowToEditJusho(GunNamePrint gun, TodofukenNamePrint todofuken, ShichosonNamePrint shichoson, KatagakiPrint katagaki, JushoEditPattern jusho) {
            this.gun = gun;
            this.todofuken = todofuken;
            this.shichoson = shichoson;
            this.katagaki = katagaki;
            this.jusho = jusho;
        }

        @Override
        public GunNamePrint for群名() {
            return this.gun;
        }

        @Override
        public TodofukenNamePrint for都道府県名() {
            return this.todofuken;
        }

        @Override
        public ShichosonNamePrint for市町村名() {
            return this.shichoson;
        }

        @Override
        public KatagakiPrint for方書() {
            return this.katagaki;
        }

        @Override
        public JushoEditPattern for住所() {
            return this.jusho;
        }
    }
}
