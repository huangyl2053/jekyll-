/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kijunt;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.GappeiShichosonEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 単一全合併市町村情報の取得します。
 *
 * @reamsid_L DBU-0250-010 wangxiaodong
 */
public class GappeiShichoson implements IKoseiShichosonMaster {

    private final GappeiShichosonEntity entity;

    /**
     * 単一合併市町村情報の取得のEntity
     *
     * @param entity GappeiShichosonEntity
     */
    public GappeiShichoson(GappeiShichosonEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村識別IDのgetメソッドです。
     *
     * @return 市町村識別ID
     */
    @Override
    public RString get市町村識別ID() {
        return null;
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    @Override
    public LasdecCode get市町村コード() {
        return entity.getKyuShichosonCode();
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        if (entity.getKyuHokenshaNo() != null) {
            return new ShoKisaiHokenshaNo(entity.getKyuHokenshaNo().value());
        }
        return ShoKisaiHokenshaNo.EMPTY;
    }

    /**
     * 国保連広域内市町村番号のgetメソッドです。
     *
     * @return 国保連広域内市町村番号
     */
    @Override
    public RString get国保連広域内市町村番号() {
        return null;
    }

    /**
     * 市町村名称のgetメソッドです。
     *
     * @return 市町村名称
     */
    @Override
    public RString get市町村名称() {
        return entity.getKyuShichosonMeisho();
    }

    /**
     * 都道府県名称のgetメソッドです。
     *
     * @return 都道府県名称
     */
    @Override
    public RString get都道府県名称() {
        return entity.getTodofukenMeisho();
    }

    /**
     * 郡名称のgetメソッドです。
     *
     * @return 郡名称
     */
    @Override
    public RString get郡名称() {
        return entity.getGunMeisho();
    }

    /**
     * 郵便番号のgetメソッドです。
     *
     * @return 郵便番号
     */
    @Override
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所のgetメソッドです。
     *
     * @return 住所
     */
    @Override
    public AtenaJusho get住所() {
        return null;
    }

    /**
     * 電話番号のgetメソッドです。
     *
     * @return 電話番号
     */
    @Override
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * 最優先地区コードのgetメソッドです。
     *
     * @return 最優先地区コード
     */
    @Override
    public RString get最優先地区コード() {
        return null;
    }

    /**
     * 帳票用都道府県名称表示有無のgetメソッドです。
     *
     * @return 帳票用都道府県名称表示有無
     */
    @Override
    public RString get帳票用都道府県名称表示有無() {
        return null;
    }

    /**
     * 帳票用郡名称表示有無のgetメソッドです。
     *
     * @return 帳票用郡名称表示有無
     */
    @Override
    public RString get帳票用郡名称表示有無() {
        return null;
    }

    /**
     * 帳票用市町村名称表示有無のgetメソッドです。
     *
     * @return 帳票用市町村名称表示有無
     */
    @Override
    public RString get帳票用市町村名称表示有無() {
        return null;
    }

    /**
     * 帳票用住所編集方法のgetメソッドです。
     *
     * @return 帳票用住所編集方法
     */
    @Override
    public RString get帳票用住所編集方法() {
        return null;
    }

    /**
     * 帳票用方書表示有無のgetメソッドです。
     *
     * @return 帳票用方書表示有無
     */
    @Override
    public RString get帳票用方書表示有無() {
        return null;
    }

    /**
     * 老人保健市町村番号のgetメソッドです。
     *
     * @return 老人保健市町村番号
     */
    @Override
    public RString get老人保健市町村番号() {
        return entity.getRojinhokenShichosonNo();
    }

    /**
     * 老人保健受給者番号体系のgetメソッドです。
     *
     * @return 老人保健受給者番号体系
     */
    @Override
    public RString get老人保健受給者番号体系() {
        return entity.getRokenJukyushaNoTaikei();
    }

    /**
     * 特徴分配集約のgetメソッドです。
     * <br/>
     * <br/>0：なし　1：あり（国保／後期）　2：あり（後期）
     *
     * @return 特徴分配集約
     */
    @Override
    public RString get特徴分配集約() {
        return null;
    }

    /**
     * 移行日のgetメソッドです。
     *
     * @return 移行日
     */
    @Override
    public FlexibleDate get移行日() {
        return null;
    }

    /**
     * 加入日のgetメソッドです。
     *
     * @return 加入日
     */
    @Override
    public FlexibleDate get加入日() {
        return null;
    }

    /**
     * 離脱日のgetメソッドです。
     *
     * @return 離脱日
     */
    @Override
    public FlexibleDate get離脱日() {
        return null;
    }

    /**
     * 合併旧市町村区分 １：合併前の旧市町村である ０：最新の広域構成市町村であるのgetメソッドです。
     *
     * @return 合併旧市町村区分 １：合併前の旧市町村である ０：最新の広域構成市町村である
     */
    @Override
    public RString get合併旧市町村区分() {
        return null;
    }

    /**
     * 合併旧市町村表示有無 合併旧市町村で表示を必要とする市町村について、表示設定が行われる １：表示する ０：表示しないのgetメソッドです。
     *
     * @return 合併旧市町村表示有無 合併旧市町村で表示を必要とする市町村について、表示設定が行われる １：表示する ０：表示しない
     */
    @Override
    public RString get合併旧市町村表示有無() {
        return null;
    }

    /**
     * 合併情報地域番号のgetメソッドです。
     *
     * @return 合併情報地域番号
     */
    @Override
    public RString get合併情報地域番号() {
        return null;
    }

    /**
     * 運用保険者番号のgetメソッドです。
     *
     * @return 運用保険者番号
     */
    @Override
    public ShoKisaiHokenshaNo get運用保険者番号() {
        return null;
    }

    /**
     * 運用開始日のgetメソッドです。
     *
     * @return 運用開始日
     */
    @Override
    public FlexibleDate get運用開始日() {
        return entity.getUnyoKaishiYMD();
    }

    /**
     * 運用終了日のgetメソッドです。
     *
     * @return 運用終了日
     */
    @Override
    public FlexibleDate get運用終了日() {
        return entity.getUnyoShuryoYMD();
    }

    /**
     * 運用形態区分のgetメソッドです。
     * <br/>
     * <br/>単独
     * <br/>広域連合
     * <br/>一部事務組合
     *
     * @return 運用形態区分
     */
    @Override
    public RString get運用形態区分() {
        return null;
    }

}
