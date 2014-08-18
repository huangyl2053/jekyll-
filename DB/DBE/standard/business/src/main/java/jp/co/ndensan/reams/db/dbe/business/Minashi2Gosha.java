/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.business.INinteiShinseiTaishosha;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.business.IJusho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * みなし2号者を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class Minashi2Gosha implements IMinashi2GoshaDaicho, INinteiShinseiTaishosha {

    private final IMinashi2GoshaDaicho daichoJoho;
    private final IKojin profile;

    /**
     * 引数からみなし2号の情報と個人情報を受け取り、インスタンスを生成します。
     *
     * @param daichoJoho みなし2号者台帳情報
     * @param profile 個人情報
     * @throws NullPointerException 引数のいずれかがnull値である場合
     */
    public Minashi2Gosha(IMinashi2GoshaDaicho daichoJoho, IKojin profile) throws NullPointerException {
        requireNonNull(daichoJoho, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("みなし2号者台帳情報", getClass().getName()));
        requireNonNull(profile, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("個人の情報", getClass().getName()));

        this.daichoJoho = daichoJoho;
        this.profile = profile;
    }

    @Override
    public KaigoHihokenshaNo get被保険者番号() {
        return daichoJoho.get被保険者番号();
    }

    @Override
    public ShikibetsuCode get識別コード() {
        return daichoJoho.get識別コード();
    }

    @Override
    public HihokenshaKubun get被保険者区分() {
        return daichoJoho.get被保険者区分();
    }

    @Override
    public IName get氏名() {
        return profile.get氏名();
    }

    @Override
    public Gender get性別() {
        return profile.get性別();
    }

    @Override
    public IDateOfBirth get生年月日() {
        return profile.get生年月日();
    }

    @Override
    public IJusho get住所() {
        return profile.get住所();
    }

    @Override
    public SetaiCode get世帯コード() {
        return profile.get世帯コード();
    }

    @Override
    public RString get個人番号() {
        return profile.get個人番号();
    }

    @Override
    public JuminShubetsu get住民種別() {
        return profile.get住民種別();
    }

    @Override
    public RString get福祉被保険者番号() {
        return daichoJoho.get福祉被保険者番号();
    }

    @Override
    public LasdecCode get市町村コード() {
        return daichoJoho.get市町村コード();
    }

    @Override
    public YMDHMS get処理日時() {
        return daichoJoho.get処理日時();
    }

    @Override
    public FlexibleDate getみなし2号登録年月日() {
        return daichoJoho.getみなし2号登録年月日();
    }

    @Override
    public FlexibleDate getみなし2号解除年月日() {
        return daichoJoho.getみなし2号解除年月日();
    }

}
