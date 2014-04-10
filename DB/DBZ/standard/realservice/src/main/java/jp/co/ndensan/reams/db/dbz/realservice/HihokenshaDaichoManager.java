/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.mapper.HihokenshaShikakuMapper;
import jp.co.ndensan.reams.db.dbz.persistence.basic.HihokenshaDaichoDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者台帳を管理するためのクラスです。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaDaichoManager {

    private final HihokenshaDaichoDac dac;
    private IKaigoSaiban<KaigoHihokenshaNo> sequencer;

    /**
     * 新しいHihokenshaDaichoManagerのインスタンスを生成します。
     */
    public HihokenshaDaichoManager() {
        this.dac = InstanceProvider.create(HihokenshaDaichoDac.class);
        this.sequencer = null;
    }

    /**
     * テスト用のコンストラクタです。dacを指定してインスタンスを生成します。
     *
     * @param dac {@link HihokenshaDiachoDac 被保険者台帳DAC}
     */
    public HihokenshaDaichoManager(HihokenshaDaichoDac dac, IKaigoSaiban<KaigoHihokenshaNo> sequencer) {
        this.dac = dac;
        this.sequencer = sequencer;
    }

    /**
     * 指定の{@link LasecCode 地方公共団体コード}, {@link ShikibetsuCode 識別コード}に該当する
     * 被保険者の資格情報を返します。<br />
     * 得られる資格情報は、直近の登録内容です。 指定の値に相当する資格情報がないときは、nullを返します。
     *
     * @param 地方公共団体コード {@link LasecCode 地方公共団体コード}
     * @param 識別コード {@link ShikibetsuCode 識別コード}
     * @return {@link IHihokenshaShikaku IHihokenshaShikaku}。もしくは、null。
     */
    IHihokenshaShikaku get直近被保険者資格(LasdecCode 地方公共団体コード, ShikibetsuCode 識別コード) {
        DbT1001HihokenshaDaichoEntity entity = dac.selectLatestOfPerson(地方公共団体コード, 識別コード);
        return HihokenshaShikakuMapper.toHihokenshaShikaku(entity);
    }

    /**
     * 指定の{@link LasecCode 地方公共団体コード}, {@link KaigoHihokenshaNo 被保険者番号}に該当する
     * 被保険者の資格情報を返します。<br />
     * 得られる資格情報は、直近の登録内容です。 指定の値に相当する資格情報がないときは、nullを返します。
     *
     * @param 地方公共団体コード {@link LasecCode 地方公共団体コード}
     * @param 被保険者番号 {@link KaigoHihokenshaNo 被保険者番号}
     * @return {@link IHihokenshaShikaku IHihokenshaShikaku}。もしくは、null。
     */
    IHihokenshaShikaku get直近被保険者資格(LasdecCode 地方公共団体コード, KaigoHihokenshaNo 被保険者番号) {
        DbT1001HihokenshaDaichoEntity entity = dac.selectLatestOfPerson(地方公共団体コード, 被保険者番号);
        return HihokenshaShikakuMapper.toHihokenshaShikaku(entity);
    }

    /**
     * 指定の項目に該当する被保険者の資格情報を返します。<br />
     * 指定の値に相当する資格情報がないときは、nullを返します。
     *
     * @param 地方公共団体コード {@link LasecCode 地方公共団体コード}
     * @param 識別コード {@link ShikibetsuCode 識別コード}
     * @param 被保険者台帳登録日時 {@link RDateTime 被保険者台帳登録日時}
     * @return {@link IHihokenshaShikaku IHihokenshaShikaku}。もしくは、null。
     */
    IHihokenshaShikaku get被保険者資格(LasdecCode 地方公共団体コード, ShikibetsuCode 識別コード, RDateTime 被保険者台帳登録日時) {
        DbT1001HihokenshaDaichoEntity entity = dac.selectFromKey(地方公共団体コード, 識別コード, 被保険者台帳登録日時);
        return HihokenshaShikakuMapper.toHihokenshaShikaku(entity);
    }

    /**
     * 地方公共団体コードを指定して、当該市町村が管理する被保険者資格情報の一覧を返します。<br />
     * 該当する資格情報がないときは、{@link Collections#EMPTY_LIST Collections.EMPTY_LIST}を返します。
     *
     * @param 地方公共団体コード {@link LasdecCode 地方公共団体コード}
     * @return {@link IHihokenshaShikaku IHihokenshaShikaku}の{@link List list}。
     * もしくは、{@link Collections#EMPTY_LIST Collections.EMPTY_LIST}。
     */
    List<IHihokenshaShikaku> get被保険者資格ListOf(LasdecCode 地方公共団体コード) {
        List<DbT1001HihokenshaDaichoEntity> entites = dac.selectAll(地方公共団体コード);
        return HihokenshaShikakuMapper.toListOfHihokenshaShikaku(entites);
    }

    /**
     * 指定の資格情報を被保険者台帳へ保存します。<br />
     * 被保険者番号のない情報が渡されたとき、被保険者番号の採番を行います。
     *
     * @param 被保険者資格 {@link IHihokenshaShikaku IHihokenshaShikaku}のオブジェクト
     * @return 成功したときはtrue, 失敗したときはfalse。
     */
    public boolean save(IHihokenshaShikaku 被保険者資格) {
        DbT1001HihokenshaDaichoEntity entity = HihokenshaShikakuMapper.toHihokenshaDaichoEntity(被保険者資格);
        if (entity.getHihokenshaNo() == KaigoHihokenshaNo.NULL_VALUE) {
            //TODO n3327 三浦凌 テスト用にいらない判定処理を設けている。採番APIの正しい使い方がわかり次第、修正する。
            if (this.sequencer == null) {
                this.sequencer = createSequencer(被保険者資格.get被保険者区分());
            }
            KaigoHihokenshaNo hihokenshaNo = this.sequencer.number();
            assert hihokenshaNo != null;
            entity.setHihokenshaNo(hihokenshaNo);
        }
        int result = this.dac.insert(entity);
        return isSuccess(result);
    }

    /**
     * 指定の資格情報を被保険者台帳から削除します。
     *
     * @param 被保険者資格 {@link IHihokenshaShikaku IHihokenshaShikaku}のオブジェクト
     * @return 成功したときはtrue, 失敗したときはfalse。
     */
    public boolean remove(IHihokenshaShikaku 被保険者資格) {
        DbT1001HihokenshaDaichoEntity entity = HihokenshaShikakuMapper.toHihokenshaDaichoEntity(被保険者資格);
        int result = this.dac.delete(entity);
        return isSuccess(result);
    }

    private boolean isSuccess(int result) {
        return 0 < result;
    }

    //TODO n3327 三浦 凌 ShikakuHihokenshaKubun に無資格者を追加し、無資格者用の採番ロジックを呼べるように修正する。 期限 : 開発終了時
    private IKaigoSaiban<KaigoHihokenshaNo> createSequencer(ShikakuHihokenshaKubun hihokenshaKubun) {
        switch (hihokenshaKubun) {
            case 第１号被保険者:
                return HihokenshaNoSaibanService.normalType();
            case 第２号被保険者:
                return HihokenshaNoSaibanService.normalType();
//            case 無資格者 :
//                return HihokenshaNoSaibanService.forMushikakushaType().number();
            default:
                return HihokenshaNoSaibanService.normalType();
        }
    }
}
