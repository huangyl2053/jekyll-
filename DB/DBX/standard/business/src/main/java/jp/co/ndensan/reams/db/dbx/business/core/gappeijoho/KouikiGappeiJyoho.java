/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.gappeijoho;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KouikiGappeiJyohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域合併情報取得結果のクラスです。
 */
public class KouikiGappeiJyoho {

    private KouikiGappeiJyohoEntity entity;

    private KouikiGappeiJyoho() {

    }

    /**
     * DBより取得した{@link KaokuSearchResultEntity}より{@link KaokuSearchResult}を生成します。
     *
     * @param entity KaokuSearchResultEntity
     */
    public KouikiGappeiJyoho(KouikiGappeiJyohoEntity entity) {
        this.entity = Objects.requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合併市町村情報検索結果"));
    }

    /**
     * 合併情報番号を返す
     *
     * @return 合併情報番号
     */
    public RString get合併情報番号() {
        return entity.getChiikiNo();
    }

    /**
     * 合併種類を返す
     *
     * @return 合併種類
     */
    public RString get合併種類() {
        return entity.getGappeiShurui();
    }

    /**
     * 合併日を返す
     *
     * @return 合併日
     */
    public FlexibleDate get合併日() {
        return entity.getGappeiYMD();
    }

    /**
     * 合併市町村コードを返す
     *
     * @return 合併市町村コード
     */
    public LasdecCode get合併市町村コード() {
        return entity.getGappeiShichosonCode();
    }

    /**
     * 保険者番号を返す
     *
     * @return 保険者番号
     */
    public ShoKisaiHokenshaNo get保険者番号() {
        return entity.getHokenshaNo();
    }

    /**
     * 旧市町村情報付与終了年月日を返す
     *
     * @return 旧市町村情報付与終了年月日
     */
    public FlexibleDate get旧市町村情報付与終了年月日() {
        return entity.getKyuJohoFuyoToYMD();
    }

    /**
     * 国保連データ連携開始年月日を返す
     *
     * @return 国保連データ連携開始年月日
     */
    public FlexibleDate get国保連データ連携開始年月日() {
        return entity.getKokuhorenDataFromYMD();
    }

    /**
     * 市町村識別IDを返す
     *
     * @return 市町村識別ID
     */
    public RString get市町村識別ID() {
        return entity.getShichosonShokibetsuID();
    }

    /**
     * 市町村コードを返す
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 証記載保険者番号を返す
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 国保連広域内市町村番号を返す
     *
     * @return 国保連広域内市町村番号
     */
    public RString get国保連広域内市町村番号() {
        return entity.getKokuhorenKoikiShichosonNo();
    }

    /**
     * 市町村名称を返す
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 都道府県名称を返す
     *
     * @return 都道府県名称
     */
    public RString get都道府県名称() {
        return entity.getTodofukenMeisho();
    }

    /**
     * 郡名称を返す
     *
     * @return 郡名称
     */
    public RString get郡名称() {
        return entity.getGunMeisho();
    }

    /**
     * 郵便番号を返す
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を返す
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 電話番号を返す
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * 最優先地区コードを返す
     *
     * @return 最優先地区コード
     */
    public RString get最優先地区コード() {
        return entity.getYusenChikuCode();
    }

    /**
     * 帳票用都道府県名称表示有無を返す
     *
     * @return 帳票用都道府県名称表示有無
     */
    public RString get帳票用都道府県名称表示有無() {
        return entity.getTyohyoTodoufukenHyojiUmu();
    }

    /**
     * 帳票用郡名称表示有無を返す
     *
     * @return 帳票用郡名称表示有無
     */
    public RString get帳票用郡名称表示有無() {
        return entity.getTyohyoGunHyojiUmu();
    }

    /**
     * 帳票用市町村名称表示有無を返す
     *
     * @return 帳票用市町村名称表示有無
     */
    public RString get帳票用市町村名称表示有無() {
        return entity.getTyohyoShichosonHyojiUmu();
    }

    /**
     * 帳票用住所編集方法を返す
     *
     * @return 帳票用住所編集方法
     */
    public RString get帳票用住所編集方法() {
        return entity.getTyohyoJushoHenshuHouhou();
    }

    /**
     * 帳票用方書表示有無を返す
     *
     * @return 帳票用方書表示有無
     */
    public RString get帳票用方書表示有無() {
        return entity.getTyohyoKatagakiHyojiUmu();
    }

    /**
     * 外国人氏名表示方法を返す
     *
     * @return 外国人氏名表示方法
     */
    public RString get外国人氏名表示方法() {
        return entity.getGaikokujinHyojiHouhou();
    }

    /**
     * 老人保健市町村番号を返す
     *
     * @return 老人保健市町村番号
     */
    public RString get老人保健市町村番号() {
        return entity.getRojinhokenShichosonNo();
    }

    /**
     * 老人保健受給者番号体系を返す
     *
     * @return 老人保健受給者番号体系
     */
    public RString get老人保健受給者番号体系() {
        return entity.getRokenJukyushaNoTaikei();
    }

    /**
     * 特徴分配集約を返す
     *
     * @return 特徴分配集約
     */
    public RString get特徴分配集約() {
        return entity.getTokuchoBunpaishuyaku();
    }

    /**
     * 移行日を返す
     *
     * @return 移行日
     */
    public FlexibleDate get移行日() {
        return entity.getIkoYMD();
    }

    /**
     * 加入日を返す
     *
     * @return 加入日
     */
    public FlexibleDate get加入日() {
        return entity.getKanyuYMD();
    }

    /**
     * 離脱日を返す
     *
     * @return 離脱日
     */
    public FlexibleDate get離脱日() {
        return entity.getRidatsuYMD();
    }

    /**
     * 合併旧市町村区分を返す
     *
     * @return 合併旧市町村区分
     */
    public RString get合併旧市町村区分() {
        return entity.getGappeiKyuShichosonKubun();
    }

    /**
     * 合併旧市町村表示有無を返す
     *
     * @return 合併旧市町村表示有無
     */
    public RString get合併旧市町村表示有無() {
        return entity.getGappeiKyuShichosonHyojiUmu();
    }

    /**
     * 合併情報地域番号を返す
     *
     * @return 合併情報地域番号
     */
    public RString get合併情報地域番号() {
        return entity.getGappeiChiikiNo();
    }

    /**
     * 運用保険者番号を返す
     *
     * @return 運用保険者番号
     */
    public ShoKisaiHokenshaNo get運用保険者番号() {
        return entity.getUnyoHokenshaNo();
    }

    /**
     * 運用開始日を返す
     *
     * @return 運用開始日
     */
    public FlexibleDate get運用開始日() {
        return entity.getUnyoKaishiYMD();
    }

    /**
     * 運用終了日を返す
     *
     * @return 運用終了日
     */
    public FlexibleDate get運用終了日() {
        return entity.getUnyoShuryoYMD();
    }

    /**
     * 運用形態区分を返す
     *
     * @return 運用形態区分
     */
    public RString get運用形態区分() {
        return entity.getUnyoKeitaiKubun();
    }

}
