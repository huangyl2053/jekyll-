/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.model.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.model.IJusho;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険の被保険者です。
 *
 * @author N3327 三浦 凌
 */
public class Hihokensha implements IHihokenshaShikaku, INinteiShinseiTaishosha {

    private final IKojin profile;
    private final IHihokenshaShikaku shikaku;

    /**
     * 個人の情報と、資格異動の情報から、被保険者を生成します。
     *
     * @param kojin 個人情報
     * @param shikaku 資格情報
     */
    public Hihokensha(IKojin kojin, IHihokenshaShikaku shikaku) {
        this.profile = requireNonNull(kojin, errorMessageFor(IKojin.class));
        this.shikaku = requireNonNull(shikaku, errorMessageFor(IHihokenshaShikaku.class));
    }

    @Override
    public LasdecCode get市町村コード() {
        return this.shikaku.get市町村コード();
    }

    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return this.shikaku.get証記載保険者番号();
    }

    @Override
    public ShikibetsuCode get識別コード() {
        return this.shikaku.get識別コード();
    }

    @Override
    public YMDHMS get処理日時() {
        return this.shikaku.get処理日時();
    }

    @Override
    public KaigoHihokenshaNo get被保険者番号() {
        return this.shikaku.get被保険者番号();
    }

    @Override
    public ShikakuShutoku get資格取得() {
        return this.shikaku.get資格取得();
    }

    @Override
    public FlexibleDate get第一号年齢到達日() {
        return this.shikaku.get第一号年齢到達日();
    }

    @Override
    public HihokenshaKubun get被保険者区分() {
        return this.shikaku.get被保険者区分();
    }

    @Override
    public boolean has被保険者資格At(RDate baseDate) {
        return this.shikaku.has被保険者資格At(baseDate);
    }

    @Override
    public ShikakuSoshitsu get資格喪失() {
        return this.shikaku.get資格喪失();
    }

    @Override
    public ShikakuHenko get資格変更() {
        return this.shikaku.get資格変更();
    }

    @Override
    public JushochitokureiTekiyo get住所地特例適用() {
        return this.shikaku.get住所地特例適用();
    }

    @Override
    public JushochitokureiKaijo get住所地特例解除() {
        return this.shikaku.get住所地特例解除();
    }

    @Override
    public JushochiTokureishaKubun get住所地特例者区分() {
        return this.shikaku.get住所地特例者区分();
    }

    @Override
    public KoikinaiJushochitokureishaKubun get広域内住所地特例者区分() {
        return this.shikaku.get広域内住所地特例者区分();
    }

    @Override
    public ShoKisaiHokenshaNo get広域内住所地特例措置元保険者番号() {
        return this.shikaku.get広域内住所地特例措置元保険者番号();
    }

    @Override
    public LasdecCode get旧市町村コード() {
        return this.shikaku.get旧市町村コード();
    }

    @Override
    public HihokenshashoSaikofu get被保険者証再交付() {
        return this.shikaku.get被保険者証再交付();
    }

    @Override
    public IKaigoShikaku toKaigoShikaku() {
        return this.shikaku.toKaigoShikaku();
    }

    @Override
    public IName get氏名() {
        return this.profile.get氏名();
    }

    @Override
    public Gender get性別() {
        return this.profile.get性別();
    }

    @Override
    public IDateOfBirth get生年月日() {
        return this.profile.get生年月日();
    }

    @Override
    public IJusho get住所() {
        return this.profile.get住所();
    }

    @Override
    public SetaiCode get世帯コード() {
        return this.profile.get世帯コード();
    }

    @Override
    public RString get個人番号() {
        return this.profile.get個人番号().value();
    }

    @Override
    public JuminShubetsu get住民種別() {
        return this.profile.get住民種別();
    }

    private String errorMessageFor(Class clazz) {
        return UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("引数の" + clazz.getSimpleName(), getClass().getSimpleName());
    }
}
