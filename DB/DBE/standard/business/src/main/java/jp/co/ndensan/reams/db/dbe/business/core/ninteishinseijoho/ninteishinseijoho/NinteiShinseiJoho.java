/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteishinseijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.image.Image;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.image.ImageIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikanryojoho.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikanryojoho.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikeikakujoho.NinteiKeikakuJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikeikakujoho.NinteiKeikakuJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.renrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.renrakusakijoho.RenrakusakiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinsakaiiinjogaijoho.ShinsakaiIinJogaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinsakaiiinjogaijoho.ShinsakaiIinJogaiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseirirekijoho.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseirirekijoho.ShinseiRirekiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseitodokedejoho.ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseitodokedejoho.ShinseitodokedeJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.tennyushibo.TennyuShibo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.tennyushibo.TennyuShiboIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.tsuchishohakkojoho.TsuchishoHakkoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.tsuchishohakkojoho.TsuchishoHakkoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5122TsuchishoHakkoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5590ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseijoho.ninteishinseijoho.NinteiShinseiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5129TennyuShiboEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定申請情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class NinteiShinseiJoho
        extends ParentModelBase<NinteiShinseiJohoIdentifier, DbT5101NinteiShinseiJohoEntity, NinteiShinseiJoho>
        implements Serializable {

    private final DbT5101NinteiShinseiJohoEntity entity;
    private final NinteiShinseiJohoIdentifier id;
    private final Models<IchiGojiHanteiKekkaJohoIdentifier, IchiGojiHanteiKekkaJoho> ichiGojiHanteiKekkaJoho;
    private final Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> ichijiHanteiKekkaJoho;
    private final Models<ImageIdentifier, Image> image;
    private final Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJoho;
    private final Models<NinteiKeikakuJohoIdentifier, NinteiKeikakuJoho> ninteiKeikakuJoho;
//    private final Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho;
    private final Models<RenrakusakiJohoIdentifier, RenrakusakiJoho> renrakusakiJoho;
    private final Models<ShinsakaiIinJogaiJohoIdentifier, ShinsakaiIinJogaiJoho> shinsakaiIinJogaiJoho;
    private final Models<ShinseiRirekiJohoIdentifier, ShinseiRirekiJoho> shinseiRirekiJoho;
    private final Models<ShinseitodokedeJohoIdentifier, ShinseitodokedeJoho> shinseitodokedeJoho;
    private final Models<TennyuShiboIdentifier, TennyuShibo> tennyuShibo;
    private final Models<TsuchishoHakkoJohoIdentifier, TsuchishoHakkoJoho> tsuchishoHakkoJoho;

    /**
     * コンストラクタです。<br/>
     * 要介護認定申請情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public NinteiShinseiJoho(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT5101NinteiShinseiJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new NinteiShinseiJohoIdentifier(
                申請書管理番号
        );
        this.ichiGojiHanteiKekkaJoho = Models.create(new ArrayList<IchiGojiHanteiKekkaJoho>());
        this.ichijiHanteiKekkaJoho = Models.create(new ArrayList<IchijiHanteiKekkaJoho>());
        this.image = Models.create(new ArrayList<Image>());
        this.ninteiKanryoJoho = Models.create(new ArrayList<NinteiKanryoJoho>());
        this.ninteiKeikakuJoho = Models.create(new ArrayList<NinteiKeikakuJoho>());
//        this.ninteiKekkaJoho = Models.create(new ArrayList<NinteiKekkaJoho>());
        this.renrakusakiJoho = Models.create(new ArrayList<RenrakusakiJoho>());
        this.shinsakaiIinJogaiJoho = Models.create(new ArrayList<ShinsakaiIinJogaiJoho>());
        this.shinseiRirekiJoho = Models.create(new ArrayList<ShinseiRirekiJoho>());
        this.shinseitodokedeJoho = Models.create(new ArrayList<ShinseitodokedeJoho>());
        this.tennyuShibo = Models.create(new ArrayList<TennyuShibo>());
        this.tsuchishoHakkoJoho = Models.create(new ArrayList<TsuchishoHakkoJoho>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5101NinteiShinseiJohoEntity}より{@link NinteiShinseiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5101NinteiShinseiJohoEntity}
     */
    public NinteiShinseiJoho(NinteiShinseiJohoRelateEntity entity) {
        this.entity = requireNonNull(entity.get要介護認定申請情報Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報"));
        this.id = new NinteiShinseiJohoIdentifier(
                entity.get要介護認定申請情報Entity().getShinseishoKanriNo());
        List<IchiGojiHanteiKekkaJoho> ichiGojiHanteiKekkaJohoList = new ArrayList<>();
        for (DbT5510IchiGojiHanteiKekkaJohoEntity ichiGojiHanteiKekkaJohoEntity : entity.get要介護認定1_5次判定結果情報Entity()) {
            ichiGojiHanteiKekkaJohoList.add(new IchiGojiHanteiKekkaJoho(ichiGojiHanteiKekkaJohoEntity));
        }
        this.ichiGojiHanteiKekkaJoho = Models.create(ichiGojiHanteiKekkaJohoList);

        List<IchijiHanteiKekkaJoho> ichijiHanteiKekkaJohoList = new ArrayList<>();
        for (DbT5116IchijiHanteiKekkaJohoEntity ichijiHanteiKekkaJohoEntity : entity.get要介護認定一次判定結果情報Entity()) {
            ichijiHanteiKekkaJohoList.add(new IchijiHanteiKekkaJoho(ichijiHanteiKekkaJohoEntity));
        }
        this.ichijiHanteiKekkaJoho = Models.create(ichijiHanteiKekkaJohoList);

        List<Image> imageList = new ArrayList<>();
        for (DbT5115ImageEntity imageEntity : entity.getイメージ情報Entity()) {
            imageList.add(new Image(imageEntity));
        }
        this.image = Models.create(imageList);

        List<NinteiKanryoJoho> ninteiKanryoJohoList = new ArrayList<>();
        for (DbT5105NinteiKanryoJohoEntity ninteiKanryoJohoEntity : entity.get要介護認定完了情報Entity()) {
            ninteiKanryoJohoList.add(new NinteiKanryoJoho(ninteiKanryoJohoEntity));
        }
        this.ninteiKanryoJoho = Models.create(ninteiKanryoJohoList);

        List<NinteiKeikakuJoho> ninteiKeikakuJohoList = new ArrayList<>();
        for (DbT5123NinteiKeikakuJohoEntity ninteiKeikakuJohoEntity : entity.get要介護認定計画情報Entity()) {
            ninteiKeikakuJohoList.add(new NinteiKeikakuJoho(ninteiKeikakuJohoEntity));
        }
        this.ninteiKeikakuJoho = Models.create(ninteiKeikakuJohoList);

//        List<NinteiKekkaJoho> ninteiKekkaJohoList = new ArrayList<>();
//        for (DbT5102NinteiKekkaJohoEntity ninteiKekkaJohoEntity : entity.get要介護認定結果情報Entity()) {
//            ninteiKekkaJohoList.add(new NinteiKekkaJoho(ninteiKekkaJohoEntity));
//        }
//        this.ninteiKekkaJoho = Models.create(ninteiKekkaJohoList);
        List<RenrakusakiJoho> renrakusakiJohoList = new ArrayList<>();
        for (DbT5150RenrakusakiJohoEntity renrakusakiJohoEntity : entity.get介護連絡先情報Entity()) {
            renrakusakiJohoList.add(new RenrakusakiJoho(renrakusakiJohoEntity));
        }
        this.renrakusakiJoho = Models.create(renrakusakiJohoList);

        List<ShinsakaiIinJogaiJoho> shinsakaiIinJogaiJohoList = new ArrayList<>();
        for (DbT5590ShinsakaiIinJogaiJohoEntity shinsakaiIinJogaiJohoEntity : entity.get審査会委員除外情報Entity()) {
            shinsakaiIinJogaiJohoList.add(new ShinsakaiIinJogaiJoho(shinsakaiIinJogaiJohoEntity));
        }
        this.shinsakaiIinJogaiJoho = Models.create(shinsakaiIinJogaiJohoList);

        List<ShinseiRirekiJoho> shinseiRirekiJohoList = new ArrayList<>();
        for (DbT5121ShinseiRirekiJohoEntity shinseiRirekiJohoEntity : entity.get申請履歴情報Entity()) {
            shinseiRirekiJohoList.add(new ShinseiRirekiJoho(shinseiRirekiJohoEntity));
        }
        this.shinseiRirekiJoho = Models.create(shinseiRirekiJohoList);

        List<ShinseitodokedeJoho> shinseitodokedeJohoList = new ArrayList<>();
        for (DbT5120ShinseitodokedeJohoEntity shinseitodokedeJohoEntity : entity.get申請届出情報Entity()) {
            shinseitodokedeJohoList.add(new ShinseitodokedeJoho(shinseitodokedeJohoEntity));
        }
        this.shinseitodokedeJoho = Models.create(shinseitodokedeJohoList);

        List<TennyuShibo> tennyuShiboList = new ArrayList<>();
        for (DbT5129TennyuShiboEntity tennyuShiboEntity : entity.get転入_死亡情報Entity()) {
            tennyuShiboList.add(new TennyuShibo(tennyuShiboEntity));
        }
        this.tennyuShibo = Models.create(tennyuShiboList);

        List<TsuchishoHakkoJoho> tsuchishoHakkoJohoList = new ArrayList<>();
        for (DbT5122TsuchishoHakkoJohoEntity tsuchishoHakkoJohoEntity : entity.get通知書発行情報Entity()) {
            tsuchishoHakkoJohoList.add(new TsuchishoHakkoJoho(tsuchishoHakkoJohoEntity));
        }
        this.tsuchishoHakkoJoho = Models.create(tsuchishoHakkoJohoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5101NinteiShinseiJohoEntity}
     * @param id {@link NinteiShinseiJohoIdentifier}
     */
    NinteiShinseiJoho(
            DbT5101NinteiShinseiJohoEntity entity,
            NinteiShinseiJohoIdentifier id,
            Models<IchiGojiHanteiKekkaJohoIdentifier, IchiGojiHanteiKekkaJoho> ichiGojiHanteiKekkaJoho,
            Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> ichijiHanteiKekkaJoho,
            Models<ImageIdentifier, Image> image,
            Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJoho,
            Models<NinteiKeikakuJohoIdentifier, NinteiKeikakuJoho> ninteiKeikakuJoho,
            //            Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho,
            Models<RenrakusakiJohoIdentifier, RenrakusakiJoho> renrakusakiJoho,
            Models<ShinsakaiIinJogaiJohoIdentifier, ShinsakaiIinJogaiJoho> shinsakaiIinJogaiJoho,
            Models<ShinseiRirekiJohoIdentifier, ShinseiRirekiJoho> shinseiRirekiJoho,
            Models<ShinseitodokedeJohoIdentifier, ShinseitodokedeJoho> shinseitodokedeJoho,
            Models<TennyuShiboIdentifier, TennyuShibo> tennyuShibo,
            Models<TsuchishoHakkoJohoIdentifier, TsuchishoHakkoJoho> tsuchishoHakkoJoho
    ) {
        this.entity = entity;
        this.id = id;
        this.ichiGojiHanteiKekkaJoho = ichiGojiHanteiKekkaJoho;
        this.ichijiHanteiKekkaJoho = ichijiHanteiKekkaJoho;
        this.image = image;
        this.ninteiKanryoJoho = ninteiKanryoJoho;
        this.ninteiKeikakuJoho = ninteiKeikakuJoho;
//        this.ninteiKekkaJoho = ninteiKekkaJoho;
        this.renrakusakiJoho = renrakusakiJoho;
        this.shinsakaiIinJogaiJoho = shinsakaiIinJogaiJoho;
        this.shinseiRirekiJoho = shinseiRirekiJoho;
        this.shinseitodokedeJoho = shinseitodokedeJoho;
        this.tennyuShibo = tennyuShibo;
        this.tsuchishoHakkoJoho = tsuchishoHakkoJoho;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 申請年度を返します。
     *
     * @return 申請年度
     */
    public FlexibleYear get申請年度() {
        return entity.getShinseiNendo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定申請枝番コードを返します。
     *
     * @return 認定申請枝番コード
     */
    public EdabanCode get認定申請枝番コード() {
        return entity.getNinteiShinseiEdabanCode();
    }

    /**
     * 認定申請区分_法令_コードを返します。
     *
     * @return 認定申請区分_法令_コード
     */
    public Code get認定申請区分_法令_コード() {
        return entity.getNinteiShinseiHoreiKubunCode();
    }

    /**
     * 認定申請区分_申請時_コードを返します。
     *
     * @return 認定申請区分_申請時_コード
     */
    public Code get認定申請区分_申請時_コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 取下区分コードを返します。
     *
     * @return 取下区分コード
     */
    public Code get取下区分コード() {
        return entity.getTorisageKubunCode();
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.getHihokenshaKubunCode();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    public int get年齢() {
        return entity.getAge();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Code get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 被保険者氏名カナを返します。
     *
     * @return 被保険者氏名カナ
     */
    public AtenaKanaMeisho get被保険者氏名カナ() {
        return entity.getHihokenshaKana();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    public RString get支所コード() {
        return entity.getShishoCode();
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
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    public ChikuCode get地区コード() {
        return entity.getChikuCode();
    }

    /**
     * みなし２号等対象フラグを返します。
     *
     * @return みなし２号等対象フラグ
     */
    public boolean isみなし２号等対象フラグ() {
        return entity.getMinashiNigoEtcTaishoFlag();
    }

    /**
     * 広域内転居区分を返します。
     *
     * @return 広域内転居区分
     */
    public Code get広域内転居区分() {
        return entity.getKoikinaiTenkyoKubun();
    }

    /**
     * 認定申請有効区分を返します。
     *
     * @return 認定申請有効区分
     */
    public Code get認定申請有効区分() {
        return entity.getNinteiShinseiYukoKubunCode();
    }

    /**
     * 要介護申請・要支援申請の区分を返します。
     *
     * @return 要介護申請・要支援申請の区分
     */
    public RString get要介護申請_要支援申請の区分() {
        return entity.getShienShinseiKubun();
    }

    /**
     * 認定申請理由を返します。
     *
     * @return 認定申請理由
     */
    public RString get認定申請理由() {
        return entity.getNinteiShinseiRiyu();
    }

    /**
     * 申請サービス削除の理由を返します。
     *
     * @return 申請サービス削除の理由
     */
    public RString get申請サービス削除の理由() {
        return entity.getShinseiServiceDeleteRiyu();
    }

    /**
     * 前回要介護状態区分コードを返します。
     *
     * @return 前回要介護状態区分コード
     */
    public Code get前回要介護状態区分コード() {
        return entity.getZenYokaigoKubunCode();
    }

    /**
     * 前回認定年月日を返します。
     *
     * @return 前回認定年月日
     */
    public FlexibleDate get前回認定年月日() {
        return entity.getZenkaiNinteiYMD();
    }

    /**
     * 前回認定有効期間_開始_を返します。
     *
     * @return 前回認定有効期間_開始_
     */
    public FlexibleDate get前回認定有効期間_開始_() {
        return entity.getZenkaiYukoKikanStart();
    }

    /**
     * 前回認定有効期間_終了_を返します。
     *
     * @return 前回認定有効期間_終了_
     */
    public FlexibleDate get前回認定有効期間_終了_() {
        return entity.getZenkaiYukoKikanEnd();
    }

    /**
     * ２号医療保険者名を返します。
     *
     * @return ２号医療保険者名
     */
    public RString get２号医療保険者名() {
        return entity.getNigoIryoHokenshaName();
    }

    /**
     * ２号医療保険記号番号を返します。
     *
     * @return ２号医療保険記号番号
     */
    public RString get２号医療保険記号番号() {
        return entity.getNigoIryoHokenKigoBango();
    }

    /**
     * ２号特定疾病コードを返します。
     *
     * @return ２号特定疾病コード
     */
    public Code get２号特定疾病コード() {
        return entity.getNigoTokuteiShippeiCode();
    }

    /**
     * 自動割当除外者区分を返します。
     *
     * @return 自動割当除外者区分
     */
    public RString get自動割当除外者区分() {
        return entity.getJidoWariateJogaishaKubun();
    }

    /**
     * 情報提供への同意有無を返します。
     *
     * @return 情報提供への同意有無
     */
    public boolean is情報提供への同意有無() {
        return entity.getJohoteikyoDoiFlag();
    }

    /**
     * 情報提供資料出力年月日を返します。
     *
     * @return 情報提供資料出力年月日
     */
    public FlexibleDate get情報提供資料出力年月日() {
        return entity.getJohoteikyoSiryoOutputYMD();
    }

    /**
     * 調査区分を返します。
     *
     * @return 調査区分
     */
    public Code get調査区分() {
        return entity.getChosaKubun();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public ChosaItakusakiCode get認定調査委託先コード() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public ChosainCode get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 調査員への連絡事項を返します。
     *
     * @return 調査員への連絡事項
     */
    public RString get調査員への連絡事項() {
        return entity.getRenrakuJikoToChosain();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        ShujiiIryokikanCode shujiiIryokikanCode = entity.getShujiiIryokikanCode();
        if (shujiiIryokikanCode != null) {
            return shujiiIryokikanCode.value();
        }
        return RString.EMPTY;
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        ShujiiCode shujiiCode = entity.getShujiiCode();
        if (shujiiCode != null) {
            return shujiiCode.value();
        }
        return RString.EMPTY;
    }

    /**
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ
     */
    public boolean is指定医フラグ() {
        return entity.getShiteiiFlag();
    }

    /**
     * 意見書データ種別を返します。
     *
     * @return 意見書データ種別
     */
    public Code get意見書データ種別() {
        return entity.getIkenshoDataShubetsu();
    }

    /**
     * 主治医への連絡事項を返します。
     *
     * @return 主治医への連絡事項
     */
    public RString get主治医への連絡事項() {
        return entity.getRenrakuJikoToShujii();
    }

    /**
     * 認定延期通知発行しないことに対する同意有無を返します。
     *
     * @return 認定延期通知発行しないことに対する同意有無
     */
    public boolean is認定延期通知発行しないことに対する同意有無() {
        return entity.getEnkitsuchiNashiDoiFlag();
    }

    /**
     * 施設入所の有無を返します。
     *
     * @return 施設入所の有無
     */
    public boolean is施設入所の有無() {
        return entity.getShisetsuNyushoFlag();
    }

    /**
     * 入所施設コードを返します。
     *
     * @return 入所施設コード
     */
    public JigyoshaNo get入所施設コード() {
        return entity.getNyushoShisetsuCode();
    }

    /**
     * 家庭訪問の有無を返します。
     *
     * @return 家庭訪問の有無
     */
    public boolean is家庭訪問の有無() {
        return entity.getKateiHomonFlag();
    }

    /**
     * 訪問調査先郵便番号を返します。
     *
     * @return 訪問調査先郵便番号
     */
    public YubinNo get訪問調査先郵便番号() {
        return entity.getHomonChosasakiYubinNo();
    }

    /**
     * 訪問調査先住所を返します。
     *
     * @return 訪問調査先住所
     */
    public AtenaJusho get訪問調査先住所() {
        return entity.getHomonChosasakiJusho();
    }

    /**
     * 訪問調査先名称を返します。
     *
     * @return 訪問調査先名称
     */
    public AtenaMeisho get訪問調査先名称() {
        return entity.getHomonChosasakiName();
    }

    /**
     * 訪問調査先電話番号を返します。
     *
     * @return 訪問調査先電話番号
     */
    public TelNo get訪問調査先電話番号() {
        return entity.getHomonChosasakiTelNo();
    }

    /**
     * 市町村連絡事項を返します。
     *
     * @return 市町村連絡事項
     */
    public RString get市町村連絡事項() {
        return entity.getShichosonRenrakuJiko();
    }

    /**
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    public Code get処理状態区分() {
        return entity.getShoriJotaiKubun();
    }

    /**
     * 取下年月日を返します。
     *
     * @return 取下年月日
     */
    public FlexibleDate get取下年月日() {
        return entity.getTorisageYMD();
    }

    /**
     * 取下理由を返します。
     *
     * @return 取下理由
     */
    public RString get取下理由() {
        return entity.getTorisageRiyu();
    }

    /**
     * 却下年月日を返します。
     *
     * @return 却下年月日
     */
    public FlexibleDate get却下年月日() {
        return entity.getKyakkaYMD();
    }

    /**
     * 却下理由を返します。
     *
     * @return 却下理由
     */
    public RString get却下理由() {
        return entity.getKyakkaRiyu();
    }

    /**
     * 延期決定年月日を返します。
     *
     * @return 延期決定年月日
     */
    public FlexibleDate get延期決定年月日() {
        return entity.getEnkiKetteiYMD();
    }

    /**
     * 延期理由を返します。
     *
     * @return 延期理由
     */
    public RString get延期理由() {
        return entity.getEnkiRiyu();
    }

    /**
     * 延期通知発行年月日を返します。
     *
     * @return 延期通知発行年月日
     */
    public FlexibleDate get延期通知発行年月日() {
        return entity.getEnkiTsuchiHakkoYMD();
    }

    /**
     * 延期通知発行回数を返します。
     *
     * @return 延期通知発行回数
     */
    public int get延期通知発行回数() {
        return entity.getEnkiTsuchiHakkoKaisu();
    }

    /**
     * 延期見込期間開始年月日を返します。
     *
     * @return 延期見込期間開始年月日
     */
    public FlexibleDate get延期見込期間開始年月日() {
        return entity.getEnkiMikomiKaishiYMD();
    }

    /**
     * 延期見込期間終了年月日を返します。
     *
     * @return 延期見込期間終了年月日
     */
    public FlexibleDate get延期見込期間終了年月日() {
        return entity.getEnkiMikomiShuryoYMD();
    }

    /**
     * 審査継続区分を返します。
     *
     * @return 審査継続区分
     */
    public boolean is審査継続区分() {
        return entity.getShinsaKeizokuFlag();
    }

    /**
     * 介護認定審査会優先振分区分コードを返します。
     *
     * @return 介護認定審査会優先振分区分コード
     */
    public Code get介護認定審査会優先振分区分コード() {
        return entity.getShinsakaiYusenWaritsukeKubunCode();
    }

    /**
     * 更新通知発行年月日を返します。
     *
     * @return 更新通知発行年月日
     */
    public FlexibleDate get更新通知発行年月日() {
        return entity.getKoshinTsuchiHakkoYMD();
    }

    /**
     * 更新通知発行完了年月日を返します。
     *
     * @return 更新通知発行完了年月日
     */
    public FlexibleDate get更新通知発行完了年月日() {
        return entity.getKoshinTsuchiHakkoKanryoYMD();
    }

    /**
     * 認定申請情報登録年月日を返します。
     *
     * @return 認定申請情報登録年月日
     */
    public FlexibleDate get認定申請情報登録年月日() {
        return entity.getNinteiShinseiJohoTorokuYMD();
    }

    /**
     * 再調査依頼回数を返します。
     *
     * @return 再調査依頼回数
     */
    public int get再調査依頼回数() {
        return entity.getSaiChosaIraiKaisu();
    }

    /**
     * 再作成依頼回数を返します。
     *
     * @return 再作成依頼回数
     */
    public int get再作成依頼回数() {
        return entity.getSaiSakuseiIraiKaisu();
    }

    /**
     * ＩＦ送付年月日を返します。
     *
     * @return ＩＦ送付年月日
     */
    public FlexibleDate getＩＦ送付年月日() {
        return entity.getIfSofuYMD();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean is論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * {@link DbT5101NinteiShinseiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5101NinteiShinseiJohoEntity}のクローン
     */
    @Override
    public DbT5101NinteiShinseiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定申請情報の識別子{@link NinteiShinseiJohoIdentifier}を返します。
     *
     * @return 要介護認定申請情報の識別子{@link NinteiShinseiJohoIdentifier}
     */
    @Override
    public NinteiShinseiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定申請情報配下の要素を削除対象とします。<br/> {@link DbT5101NinteiShinseiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 要介護認定申請情報配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link NinteiShinseiJoho}を返します。
     *
     * @return 削除対象処理実施後の{@link NinteiShinseiJoho}
     * @throws IllegalStateException DbT5101NinteiShinseiJohoEntityのデータ状態が変更の場合
     */
    @Override
    public NinteiShinseiJoho deleted() {
        DbT5101NinteiShinseiJohoEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteiShinseiJoho(
                deletedEntity,
                id,
                ichiGojiHanteiKekkaJoho.deleted(),
                ichijiHanteiKekkaJoho.deleted(),
                image.deleted(),
                ninteiKanryoJoho.deleted(),
                ninteiKeikakuJoho.deleted(),
                //                ninteiKekkaJoho.deleted(),
                renrakusakiJoho.deleted(),
                shinsakaiIinJogaiJoho.deleted(),
                shinseiRirekiJoho.deleted(),
                shinseitodokedeJoho.deleted(),
                tennyuShibo.deleted(),
                tsuchishoHakkoJoho.deleted());
    }

    @Override
    public boolean hasChanged() {

        return hasChangedEntity()
                || ichiGojiHanteiKekkaJoho.hasAnyChanged()
                || ichijiHanteiKekkaJoho.hasAnyChanged()
                || image.hasAnyChanged()
                || ninteiKanryoJoho.hasAnyChanged()
                || ninteiKeikakuJoho.hasAnyChanged()
                //                || ninteiKekkaJoho.hasAnyChanged()
                || renrakusakiJoho.hasAnyChanged()
                || shinsakaiIinJogaiJoho.hasAnyChanged()
                || shinseiRirekiJoho.hasAnyChanged()
                || shinseitodokedeJoho.hasAnyChanged()
                || tennyuShibo.hasAnyChanged()
                || tsuchishoHakkoJoho.hasAnyChanged();

    }

    /**
     * 要介護認定申請情報のみを変更対象とします。<br/> {@link DbT5101NinteiShinseiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteiShinseiJoho}
     */
    @Override
    public NinteiShinseiJoho modifiedModel() {
        DbT5101NinteiShinseiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
//        return new NinteiShinseiJoho(
//                modifiedEntity, id, ichiGojiHanteiKekkaJoho,
//        ichijiHanteiKekkaJoho, image, ninteiKanryoJoho, ninteiKeikakuJoho, null,
//        renrakusakiJoho, shinsakaiIinJogaiJoho, shinseiRirekiJoho, shinseitodokedeJoho,
//        tennyuShibo, tsuchishoHakkoJoho);
        return null;
    }

    /**
     * 要介護認定1.5次判定結果情報が保持する要介護認定1.5次判定結果情報に対して、指定の識別子に該当する要介護認定1.5次判定結果情報を返します。
     *
     * @param id 要介護認定1.5次判定結果情報の識別子
     * @return 要介護認定1.5次判定結果情報
     * @throws IllegalStateException 指定の識別子に該当する要介護認定1.5次判定結果情報がない場合
     */
    public IchiGojiHanteiKekkaJoho getIchiGojiHanteiKekkaJoho(IchiGojiHanteiKekkaJohoIdentifier id) {
        if (ichiGojiHanteiKekkaJoho.contains(id)) {
            return ichiGojiHanteiKekkaJoho.clone().get(id);
        }

        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 要介護認定申請情報が保持する要介護認定1.5次判定結果情報をリストで返します。
     *
     * @return 要介護認定1.5次判定結果情報リスト
     */
    public List<IchiGojiHanteiKekkaJoho> getIchiGojiHanteiKekkaJohoList() {
        return new ArrayList<>(ichiGojiHanteiKekkaJoho.values());

    }

    /**
     * 要介護認定一次判定結果情報を取得する
     *
     * @param id IchijiHanteiKekkaJohoIdentifier
     * @return IchijiHanteiKekkaJoho
     */
    public IchijiHanteiKekkaJoho getIchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoIdentifier id) {
        if (ichijiHanteiKekkaJoho.contains(id)) {
            return ichijiHanteiKekkaJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 要介護認定一次判定結果情報リストを取得する
     *
     * @return List<IchijiHanteiKekkaJoho>
     */
    public List<IchijiHanteiKekkaJoho> getIchijiHanteiKekkaJohoList() {
        return new ArrayList<>(ichijiHanteiKekkaJoho.values());
    }

    /**
     * イメージ情報を取得する
     *
     * @param id ImageIdentifier
     * @return Image
     */
    public Image getImage(ImageIdentifier id) {
        if (image.contains(id)) {
            return image.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * イメージ情報リストを取得する
     *
     * @return List<Image>
     */
    public List<Image> getImageList() {
        return new ArrayList<>(image.values());
    }

    /**
     * 要介護認定完了情報を取得する
     *
     * @param id NinteiKanryoJohoIdentifier
     * @return NinteiKanryoJoho
     */
    public NinteiKanryoJoho getNinteiKanryoJoho(NinteiKanryoJohoIdentifier id) {
        if (ninteiKanryoJoho.contains(id)) {
            return ninteiKanryoJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 要介護認定完了情報リストを取得する
     *
     * @return List<NinteiKanryoJoho>
     */
    public List<NinteiKanryoJoho> getNinteiKanryoJohoList() {
        return new ArrayList<>(ninteiKanryoJoho.values());
    }

    /**
     * 要介護認定計画情報を取得する
     *
     * @param id NinteiKeikakuJohoIdentifier
     * @return NinteiKeikakuJoho
     */
    public NinteiKeikakuJoho getNinteiKeikakuJoho(NinteiKeikakuJohoIdentifier id) {
        if (ninteiKeikakuJoho.contains(id)) {
            return ninteiKeikakuJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 要介護認定計画情報リストを取得する
     *
     * @return List<NinteiKeikakuJoho>
     */
    public List<NinteiKeikakuJoho> getNinteiKeikakuJohoList() {
        return new ArrayList<>(ninteiKeikakuJoho.values());
    }

//    public NinteiKekkaJoho getNinteiKekkaJoho(NinteiKekkaJohoIdentifier id) {
////        if (ninteiKekkaJoho.contains(id)) {
////            return ninteiKekkaJoho.clone().get(id);
////        }
//        //TODO メッセージの検討
//        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
//    }
//    public List<NinteiKekkaJoho> getNinteiKekkaJohoList() {
//        return new ArrayList<>(ninteiKekkaJoho.values());
//    }
    /**
     * 介護連絡先情報を取得する
     *
     * @param id RenrakusakiJohoIdentifier
     * @return RenrakusakiJoho
     */
    public RenrakusakiJoho getRenrakusakiJoho(RenrakusakiJohoIdentifier id) {
        if (renrakusakiJoho.contains(id)) {
            return renrakusakiJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 介護連絡先情報リストを取得する
     *
     * @return List<RenrakusakiJoho>
     */
    public List<RenrakusakiJoho> getRenrakusakiJohoList() {
        return new ArrayList<>(renrakusakiJoho.values());
    }

    /**
     * 審査会委員除外情報を取得する
     *
     * @param id ShinsakaiIinJogaiJohoIdentifier
     * @return ShinsakaiIinJogaiJoho
     */
    public ShinsakaiIinJogaiJoho getShinsakaiIinJogaiJoho(ShinsakaiIinJogaiJohoIdentifier id) {
        if (shinsakaiIinJogaiJoho.contains(id)) {
            return shinsakaiIinJogaiJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 審査会委員除外情報リストを取得する
     *
     * @return List<ShinsakaiIinJogaiJoho>
     */
    public List<ShinsakaiIinJogaiJoho> getShinsakaiIinJogaiJohoList() {
        return new ArrayList<>(shinsakaiIinJogaiJoho.values());
    }

    /**
     * 申請履歴情報を取得する
     *
     * @param id ShinseiRirekiJohoIdentifier
     * @return ShinseiRirekiJoho
     */
    public ShinseiRirekiJoho getShinseiRirekiJoho(ShinseiRirekiJohoIdentifier id) {
        if (shinseiRirekiJoho.contains(id)) {
            return shinseiRirekiJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 申請履歴情報リストを取得する
     *
     * @return List<ShinseiRirekiJoho>
     */
    public List<ShinseiRirekiJoho> getShinseiRirekiJohoList() {
        return new ArrayList<>(shinseiRirekiJoho.values());
    }

    /**
     * 申請届出情報を取得する
     *
     * @param id ShinseitodokedeJohoIdentifier
     * @return ShinseitodokedeJoho
     */
    public ShinseitodokedeJoho getShinseitodokedeJoho(ShinseitodokedeJohoIdentifier id) {
        if (shinseitodokedeJoho.contains(id)) {
            return shinseitodokedeJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 申請届出情報リストを取得する
     *
     * @return List<ShinseitodokedeJoho>
     */
    public List<ShinseitodokedeJoho> getShinseitodokedeJohoList() {
        return new ArrayList<>(shinseitodokedeJoho.values());
    }

    /**
     * 転入・死亡情報を取得する
     *
     * @param id TennyuShiboIdentifier
     * @return TennyuShibo
     */
    public TennyuShibo getTennyuShibo(TennyuShiboIdentifier id) {
        if (tennyuShibo.contains(id)) {
            return tennyuShibo.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 転入・死亡情報リストを取得する
     *
     * @return List<TennyuShibo>
     */
    public List<TennyuShibo> getTennyuShiboList() {
        return new ArrayList<>(tennyuShibo.values());
    }

    /**
     * 通知書発行情報を取得する
     *
     * @param id TsuchishoHakkoJohoIdentifier
     * @return TsuchishoHakkoJoho
     */
    public TsuchishoHakkoJoho getTsuchishoHakkoJoho(TsuchishoHakkoJohoIdentifier id) {
        if (tsuchishoHakkoJoho.contains(id)) {
            return tsuchishoHakkoJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 通知書発行情報リストを取得する
     *
     * @return List<TsuchishoHakkoJoho>
     */
    public List<TsuchishoHakkoJoho> getTsuchishoHakkoJohoList() {
        return new ArrayList<>(tsuchishoHakkoJoho.values());
    }

    /**
     * {@link NinteiShinseiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link NinteiShinseiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return null;
//        return new _SerializationProxy(entity, id, ichiGojiHanteiKekkaJoho,
//        ichijiHanteiKekkaJoho, image, ninteiKanryoJoho, ninteiKeikakuJoho, null,
//        renrakusakiJoho, shinsakaiIinJogaiJoho, shinseiRirekiJoho, shinseitodokedeJoho,
//        tennyuShibo, tsuchishoHakkoJoho);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT5101NinteiShinseiJohoEntity entity;
        private final NinteiShinseiJohoIdentifier id;
        private final Models<IchiGojiHanteiKekkaJohoIdentifier, IchiGojiHanteiKekkaJoho> ichiGojiHanteiKekkaJoho;
        private final Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> ichijiHanteiKekkaJoho;
        private final Models<ImageIdentifier, Image> image;
        private final Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJoho;
        private final Models<NinteiKeikakuJohoIdentifier, NinteiKeikakuJoho> ninteiKeikakuJoho;
//        private final Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho;
        private final Models<RenrakusakiJohoIdentifier, RenrakusakiJoho> renrakusakiJoho;
        private final Models<ShinsakaiIinJogaiJohoIdentifier, ShinsakaiIinJogaiJoho> shinsakaiIinJogaiJoho;
        private final Models<ShinseiRirekiJohoIdentifier, ShinseiRirekiJoho> shinseiRirekiJoho;
        private final Models<ShinseitodokedeJohoIdentifier, ShinseitodokedeJoho> shinseitodokedeJoho;
        private final Models<TennyuShiboIdentifier, TennyuShibo> tennyuShibo;
        private final Models<TsuchishoHakkoJohoIdentifier, TsuchishoHakkoJoho> tsuchishoHakkoJoho;

        private _SerializationProxy(
                DbT5101NinteiShinseiJohoEntity entity,
                NinteiShinseiJohoIdentifier id,
                Models<IchiGojiHanteiKekkaJohoIdentifier, IchiGojiHanteiKekkaJoho> ichiGojiHanteiKekkaJoho,
                Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> ichijiHanteiKekkaJoho,
                Models<ImageIdentifier, Image> image,
                Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJoho,
                Models<NinteiKeikakuJohoIdentifier, NinteiKeikakuJoho> ninteiKeikakuJoho,
                //                Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho,
                Models<RenrakusakiJohoIdentifier, RenrakusakiJoho> renrakusakiJoho,
                Models<ShinsakaiIinJogaiJohoIdentifier, ShinsakaiIinJogaiJoho> shinsakaiIinJogaiJoho,
                Models<ShinseiRirekiJohoIdentifier, ShinseiRirekiJoho> shinseiRirekiJoho,
                Models<ShinseitodokedeJohoIdentifier, ShinseitodokedeJoho> shinseitodokedeJoho,
                Models<TennyuShiboIdentifier, TennyuShibo> tennyuShibo,
                Models<TsuchishoHakkoJohoIdentifier, TsuchishoHakkoJoho> tsuchishoHakkoJoho
        ) {
            this.entity = entity;
            this.id = id;
            this.ichiGojiHanteiKekkaJoho = ichiGojiHanteiKekkaJoho;
            this.ichijiHanteiKekkaJoho = ichijiHanteiKekkaJoho;
            this.image = image;
            this.ninteiKanryoJoho = ninteiKanryoJoho;
            this.ninteiKeikakuJoho = ninteiKeikakuJoho;
//            this.ninteiKekkaJoho = ninteiKekkaJoho;
            this.renrakusakiJoho = renrakusakiJoho;
            this.shinsakaiIinJogaiJoho = shinsakaiIinJogaiJoho;
            this.shinseiRirekiJoho = shinseiRirekiJoho;
            this.shinseitodokedeJoho = shinseitodokedeJoho;
            this.tennyuShibo = tennyuShibo;
            this.tsuchishoHakkoJoho = tsuchishoHakkoJoho;
        }

        private Object readResolve() {
            return null;
//            return new NinteiShinseiJoho(this.entity, this.id, this.ichiGojiHanteiKekkaJoho,
//            this.ichijiHanteiKekkaJoho, this.image, this.ninteiKanryoJoho, this.ninteiKeikakuJoho,
//            null, this.renrakusakiJoho, this.shinsakaiIinJogaiJoho, this.shinseiRirekiJoho,
//            this.shinseitodokedeJoho, this.tennyuShibo, this.tsuchishoHakkoJoho);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link NinteiShinseiJohoBuilder#build()}を使用してください。
     *
     * @return {@link NinteiShinseiJohoBuilder}
     */
    public NinteiShinseiJohoBuilder createBuilderForEdit() {
        return null;
//        return new NinteiShinseiJohoBuilder(entity, id, ichiGojiHanteiKekkaJoho,
//        ichijiHanteiKekkaJoho, image, ninteiKanryoJoho, ninteiKeikakuJoho, null,
//        renrakusakiJoho, shinsakaiIinJogaiJoho, shinseiRirekiJoho, shinseitodokedeJoho,
//        tennyuShibo, tsuchishoHakkoJoho);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final NinteiShinseiJoho other = (NinteiShinseiJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
