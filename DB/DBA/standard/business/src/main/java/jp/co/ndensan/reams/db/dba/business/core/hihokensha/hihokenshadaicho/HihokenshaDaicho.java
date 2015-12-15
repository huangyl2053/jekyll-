/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.hihokenshadaicho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyoIdentifier;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.jukyushadaicho.JukyushaDaicho;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.jukyushadaicho.JukyushaDaichoIdentifier;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaIdentifier;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.shisetsunyutaisho.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokensha.hihokenshadaicho.HihokenshaDaichoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 被保険者台帳管理を管理するクラスです。
 */
public class HihokenshaDaicho extends ParentModelBase<HihokenshaDaichoIdentifier, DbT1001HihokenshaDaichoEntity, HihokenshaDaicho> implements Serializable {

    private final DbT1001HihokenshaDaichoEntity entity;
    private final HihokenshaDaichoIdentifier id;
    private final Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho;
    private final Models<IryohokenKanyuJokyoIdentifier, IryohokenKanyuJokyo> iryohokenKanyuJokyo;
    private final Models<JukyushaDaichoIdentifier, JukyushaDaicho> jukyushaDaicho;
    private final Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha;

    /**
     * コンストラクタです。<br/>
     * 被保険者台帳管理の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @param 枝番 枝番
     */
    public HihokenshaDaicho(HihokenshaNo 被保険者番号,
            FlexibleDate 異動日,
            RString 枝番) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        this.entity = new DbT1001HihokenshaDaichoEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setIdoYMD(異動日);
        this.entity.setEdaNo(枝番);
        this.id = new HihokenshaDaichoIdentifier(
                被保険者番号,
                異動日,
                枝番
        );
        this.shisetsuNyutaisho = Models.create(new ArrayList<ShisetsuNyutaisho>());
        this.iryohokenKanyuJokyo = Models.create(new ArrayList<IryohokenKanyuJokyo>());
        this.jukyushaDaicho = Models.create(new ArrayList<JukyushaDaicho>());
        this.roreiFukushiNenkinJukyusha = Models.create(new ArrayList<RoreiFukushiNenkinJukyusha>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1001HihokenshaDaichoEntity}より{@link HihokenshaDaicho}を生成します。
     *
     * @param entity DBより取得した{@link DbT1001HihokenshaDaichoEntity}
     */
    public HihokenshaDaicho(HihokenshaDaichoRelateEntity entity) {
        this.entity = requireNonNull(entity.get被保険者台帳管理Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理"));
        this.id = new HihokenshaDaichoIdentifier(
                entity.get被保険者台帳管理Entity().getHihokenshaNo(),
                entity.get被保険者台帳管理Entity().getIdoYMD(),
                entity.get被保険者台帳管理Entity().getEdaNo()
        );
        List<ShisetsuNyutaisho> shisetsuNyutaishoList = new ArrayList<>();
        for (DbT1004ShisetsuNyutaishoEntity nyutaishoEntity : entity.get介護保険施設入退所Entity()) {
            shisetsuNyutaishoList.add(new ShisetsuNyutaisho(nyutaishoEntity));
        }
        this.shisetsuNyutaisho = Models.create(shisetsuNyutaishoList);

        List<IryohokenKanyuJokyo> iryohokenKanyuJokyoList = new ArrayList<>();
        for (DbT1008IryohokenKanyuJokyoEntity kanyuJokyoEntity : entity.get介護保険医療保険加入状況Entity()) {
            iryohokenKanyuJokyoList.add(new IryohokenKanyuJokyo(kanyuJokyoEntity));
        }
        this.iryohokenKanyuJokyo = Models.create(iryohokenKanyuJokyoList);

        List<JukyushaDaicho> jukyushaDaichoList = new ArrayList<>();
        for (DbT4001JukyushaDaichoEntity daichoEntity : entity.get受給者台帳Entity()) {
            jukyushaDaichoList.add(new JukyushaDaicho(daichoEntity));
        }
        this.jukyushaDaicho = Models.create(jukyushaDaichoList);

        List<RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyushaList = new ArrayList<>();
        for (DbT7006RoreiFukushiNenkinJukyushaEntity jukyushaEntity : entity.get老齢福祉年金受給者Entity()) {
            roreiFukushiNenkinJukyushaList.add(new RoreiFukushiNenkinJukyusha(jukyushaEntity));
        }
        this.roreiFukushiNenkinJukyusha = Models.create(roreiFukushiNenkinJukyushaList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1001HihokenshaDaichoEntity}
     * @param id {@link HihokenshaDaichoIdentifier}
     */
    HihokenshaDaicho(
            DbT1001HihokenshaDaichoEntity entity,
            HihokenshaDaichoIdentifier id,
            Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho,
            Models<IryohokenKanyuJokyoIdentifier, IryohokenKanyuJokyo> iryohokenKanyuJokyo,
            Models<JukyushaDaichoIdentifier, JukyushaDaicho> jukyushaDaicho,
            Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha
    ) {
        this.entity = entity;
        this.id = id;
        this.shisetsuNyutaisho = shisetsuNyutaisho;
        this.iryohokenKanyuJokyo = iryohokenKanyuJokyo;
        this.jukyushaDaicho = jukyushaDaicho;
        this.roreiFukushiNenkinJukyusha = roreiFukushiNenkinJukyusha;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 異動日を返します。
     *
     * @return 異動日
     */
    public FlexibleDate get異動日() {
        return entity.getIdoYMD();
    }

    /**
     * 枝番を返します。
     *
     * @return 枝番
     */
    public RString get枝番() {
        return entity.getEdaNo();
    }

    /**
     * 異動事由コードを返します。
     *
     * @return 異動事由コード
     */
    public RString get異動事由コード() {
        return entity.getIdoJiyuCode();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 資格取得事由コードを返します。
     *
     * @return 資格取得事由コード
     */
    public RString get資格取得事由コード() {
        return entity.getShikakuShutokuJiyuCode();
    }

    /**
     * 資格取得年月日を返します。
     *
     * @return 資格取得年月日
     */
    public FlexibleDate get資格取得年月日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格取得届出年月日を返します。
     *
     * @return 資格取得届出年月日
     */
    public FlexibleDate get資格取得届出年月日() {
        return entity.getShikakuShutokuTodokedeYMD();
    }

    /**
     * 第1号資格取得年月日を返します。
     *
     * @return 第1号資格取得年月日
     */
    public FlexibleDate get第1号資格取得年月日() {
        return entity.getIchigoShikakuShutokuYMD();
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.getHihokennshaKubunCode();
    }

    /**
     * 資格喪失事由コードを返します。
     *
     * @return 資格喪失事由コード
     */
    public RString get資格喪失事由コード() {
        return entity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * 資格喪失年月日を返します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失届出年月日を返します。
     *
     * @return 資格喪失届出年月日
     */
    public FlexibleDate get資格喪失届出年月日() {
        return entity.getShikakuSoshitsuTodokedeYMD();
    }

    /**
     * 資格変更事由コードを返します。
     *
     * @return 資格変更事由コード
     */
    public RString get資格変更事由コード() {
        return entity.getShikakuHenkoJiyuCode();
    }

    /**
     * 資格変更年月日を返します。
     *
     * @return 資格変更年月日
     */
    public FlexibleDate get資格変更年月日() {
        return entity.getShikakuHenkoYMD();
    }

    /**
     * 資格変更届出年月日を返します。
     *
     * @return 資格変更届出年月日
     */
    public FlexibleDate get資格変更届出年月日() {
        return entity.getShikakuHenkoTodokedeYMD();
    }

    /**
     * 住所地特例適用事由コードを返します。
     *
     * @return 住所地特例適用事由コード
     */
    public RString get住所地特例適用事由コード() {
        return entity.getJushochitokureiTekiyoJiyuCode();
    }

    /**
     * 適用年月日を返します。
     *
     * @return 適用年月日
     */
    public FlexibleDate get適用年月日() {
        return entity.getJushochitokureiTekiyoYMD();
    }

    /**
     * 適用届出年月日を返します。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate get適用届出年月日() {
        return entity.getJushochitokureiTekiyoTodokedeYMD();
    }

    /**
     * 住所地特例解除事由コードを返します。
     *
     * @return 住所地特例解除事由コード
     */
    public RString get住所地特例解除事由コード() {
        return entity.getJushochitokureiKaijoJiyuCode();
    }

    /**
     * 解除年月日を返します。
     *
     * @return 解除年月日
     */
    public FlexibleDate get解除年月日() {
        return entity.getJushochitokureiKaijoYMD();
    }

    /**
     * 解除届出年月日を返します。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate get解除届出年月日() {
        return entity.getJushochitokureiKaijoTodokedeYMD();
    }

    /**
     * 住所地特例フラグを返します。
     *
     * @return 住所地特例フラグ
     */
    public RString get住所地特例フラグ() {
        return entity.getJushochiTokureiFlag();
    }

    /**
     * 広域内住所地特例フラグを返します。
     *
     * @return 広域内住所地特例フラグ
     */
    public RString get広域内住所地特例フラグ() {
        return entity.getKoikinaiJushochiTokureiFlag();
    }

    /**
     * 広住特措置元市町村コードを返します。
     *
     * @return 広住特措置元市町村コード
     */
    public LasdecCode get広住特措置元市町村コード() {
        return entity.getKoikinaiTokureiSochimotoShichosonCode();
    }

    /**
     * 旧市町村コードを返します。
     *
     * @return 旧市町村コード
     */
    public LasdecCode get旧市町村コード() {
        return entity.getKyuShichosonCode();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean get論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * {@link DbT1001HihokenshaDaichoEntity}のクローンを返します。
     *
     * @return {@link DbT1001HihokenshaDaichoEntity}のクローン
     */
    @Override
    public DbT1001HihokenshaDaichoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 被保険者台帳管理の識別子{@link HihokenshaDaichoIdentifier}を返します。
     *
     * @return 被保険者台帳管理の識別子{@link HihokenshaDaichoIdentifier}
     */
    @Override
    public HihokenshaDaichoIdentifier identifier() {
        return this.id;
    }

    /**
     * 被保険者台帳管理配下の要素を削除対象とします。<br/>
     * {@link DbT1001HihokenshaDaichoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 被保険者台帳管理配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link HihokenshaDaicho}を返します。
     *
     * @return 削除対象処理実施後の{@link HihokenshaDaicho}
     * @throws IllegalStateException DbT1001HihokenshaDaichoEntityのデータ状態が変更の場合
     */
    @Override
    public HihokenshaDaicho deleted() {
        DbT1001HihokenshaDaichoEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new HihokenshaDaicho(
                deletedEntity, id, shisetsuNyutaisho.deleted(), iryohokenKanyuJokyo.deleted(),
                jukyushaDaicho.deleted(), roreiFukushiNenkinJukyusha.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || shisetsuNyutaisho.hasAnyChanged() || iryohokenKanyuJokyo.hasAnyChanged()
                || jukyushaDaicho.hasAnyChanged() || roreiFukushiNenkinJukyusha.hasAnyChanged();
    }

    /**
     * 被保険者台帳管理のみを変更対象とします。<br/>
     * {@link DbT1001HihokenshaDaichoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link HihokenshaDaicho}
     */
    @Override
    public HihokenshaDaicho modifiedModel() {
        DbT1001HihokenshaDaichoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new HihokenshaDaicho(
                modifiedEntity, id, shisetsuNyutaisho, iryohokenKanyuJokyo,
                jukyushaDaicho, roreiFukushiNenkinJukyusha);
    }

    /**
     * 被保険者台帳管理が保持する介護保険施設入退所情報に対して、指定の識別子に該当する介護保険施設入退所情報を返します。
     *
     * @param id 介護保険施設入退所情報の識別子
     * @return 精介護保険施設入退所情報
     * @throws IllegalStateException 指定の識別子に該当する介護保険施設入退所情報がない場合
     */
    public ShisetsuNyutaisho getShisetsuNyutaisho(ShisetsuNyutaishoIdentifier id) {
        if (shisetsuNyutaisho.contains(id)) {
            return shisetsuNyutaisho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 被保険者台帳管理が保持する介護保険施設入退所情報をリストで返します。
     *
     * @return 介護保険施設入退所情報リスト
     */
    public List<ShisetsuNyutaisho> getShisetsuNyutaishoList() {
        return new ArrayList<>(shisetsuNyutaisho.values());

    }

    /**
     * 被保険者台帳管理が保持する介護保険医療保険加入状況情報に対して、指定の識別子に該当する介護保険医療保険加入状況情報を返します。
     *
     * @param id 介護保険医療保険加入状況情報の識別子
     * @return 介護保険医療保険加入状況情報
     * @throws IllegalStateException 指定の識別子に該当する介護保険医療保険加入状況情報がない場合
     */
    public IryohokenKanyuJokyo getIryohokenKanyuJokyo(IryohokenKanyuJokyoIdentifier id) {
        if (iryohokenKanyuJokyo.contains(id)) {
            return iryohokenKanyuJokyo.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 被保険者台帳管理が保持する介護保険医療保険加入状況情報をリストで返します。
     *
     * @return 介護保険医療保険加入状況情報リスト
     */
    public List<IryohokenKanyuJokyo> getIryohokenKanyuJokyoList() {
        return new ArrayList<>(iryohokenKanyuJokyo.values());
    }

    /**
     * 被保険者台帳管理が保持する受給者台帳情報に対して、指定の識別子に該当する受給者台帳情報を返します。
     *
     * @param id 受給者台帳情報の識別子
     * @return 受給者台帳情報
     * @throws IllegalStateException 指定の識別子に該当する受給者台帳情報がない場合
     */
    public JukyushaDaicho getJukyushaDaicho(JukyushaDaichoIdentifier id) {
        if (jukyushaDaicho.contains(id)) {
            return jukyushaDaicho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 被保険者台帳管理が保持する受給者台帳情報をリストで返します。
     *
     * @return 受給者台帳情報リスト
     */
    public List<JukyushaDaicho> getJukyushaDaichoList() {
        return new ArrayList<>(jukyushaDaicho.values());
    }

    /**
     * 被保険者台帳管理が保持する老齢福祉年金受給者情報に対して、指定の識別子に該当する老齢福祉年金受給者情報を返します。
     *
     * @param id 老齢福祉年金受給者情報の識別子
     * @return 老齢福祉年金受給者情報
     * @throws IllegalStateException 指定の識別子に該当する老齢福祉年金受給者情報がない場合
     */
    public RoreiFukushiNenkinJukyusha getRoreiFukushiNenkinJukyusha(RoreiFukushiNenkinJukyushaIdentifier id) {
        if (roreiFukushiNenkinJukyusha.contains(id)) {
            return roreiFukushiNenkinJukyusha.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 被保険者台帳管理が保持する老齢福祉年金受給者情報をリストで返します。
     *
     * @return 老齢福祉年金受給者情報リスト
     */
    public List<RoreiFukushiNenkinJukyusha> getRoreiFukushiNenkinJukyushaList() {
        return new ArrayList<>(roreiFukushiNenkinJukyusha.values());
    }

    /**
     * {@link HihokenshaDaicho}のシリアライズ形式を提供します。
     *
     * @return {@link HihokenshaDaicho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, shisetsuNyutaisho, iryohokenKanyuJokyo,
                jukyushaDaicho, roreiFukushiNenkinJukyusha);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT1001HihokenshaDaichoEntity entity;
        private final HihokenshaDaichoIdentifier id;
        private final Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho;
        private final Models<IryohokenKanyuJokyoIdentifier, IryohokenKanyuJokyo> iryohokenKanyuJokyo;
        private final Models<JukyushaDaichoIdentifier, JukyushaDaicho> jukyushaDaicho;
        private final Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha;

        private _SerializationProxy(
                DbT1001HihokenshaDaichoEntity entity,
                HihokenshaDaichoIdentifier id,
                Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho,
                Models<IryohokenKanyuJokyoIdentifier, IryohokenKanyuJokyo> iryohokenKanyuJokyo,
                Models<JukyushaDaichoIdentifier, JukyushaDaicho> jukyushaDaicho,
                Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha
        ) {
            this.entity = entity;
            this.id = id;
            this.shisetsuNyutaisho = shisetsuNyutaisho;
            this.iryohokenKanyuJokyo = iryohokenKanyuJokyo;
            this.jukyushaDaicho = jukyushaDaicho;
            this.roreiFukushiNenkinJukyusha = roreiFukushiNenkinJukyusha;
        }

        private Object readResolve() {
            return new HihokenshaDaicho(this.entity, this.id, this.shisetsuNyutaisho, this.iryohokenKanyuJokyo,
                    this.jukyushaDaicho, this.roreiFukushiNenkinJukyusha);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link HihokenshaDaichoBuilder#build()}を使用してください。
     *
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder createBuilderForEdit() {
        return new HihokenshaDaichoBuilder(entity, id, shisetsuNyutaisho, iryohokenKanyuJokyo,
                jukyushaDaicho, roreiFukushiNenkinJukyusha);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HihokenshaDaicho other = (HihokenshaDaicho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
