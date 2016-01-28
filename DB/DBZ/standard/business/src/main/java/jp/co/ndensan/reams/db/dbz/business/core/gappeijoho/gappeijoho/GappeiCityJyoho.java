/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.gappeijoho.GappeiCityJyohoRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併市町村情報取得結果のクラスです。
 */
public class GappeiCityJyoho {

    private GappeiCityJyohoRelateEntity entity;

    private GappeiCityJyoho() {

    }

    /**
     * DBより取得した{@link GappeiCityJyohoRelateEntity}より{@link GappeiCityJyoho}を生成します。
     *
     * @param entity 合併市町村情報取得用_返却Enitity
     */
    public GappeiCityJyoho(GappeiCityJyohoRelateEntity entity) {
        this.entity = Objects.requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合併市町村情報検索結果"));
    }

    /**
     * 合併情報番号を取得します。
     *
     * @return 合併情報番号
     */
    public RString get合併情報番号() {
        return this.entity.getChiikiNo();
    }

    /**
     * 合併種類を取得します。
     *
     * @return 合併種類
     */
    public RString get合併種類() {
        return this.entity.getGappeiShurui();
    }

    /**
     * 合併日を取得します。
     *
     * @return 合併日
     */
    public FlexibleDate get合併日() {
        return this.entity.getGappeiYMD();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return this.entity.getShichosonCode();
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return this.entity.getHokenshaNo();
    }

    /**
     * 旧市町村情報付与終了年月日を取得します。
     *
     * @return 旧市町村情報付与終了年月日
     */
    public FlexibleDate get旧市町村情報付与終了年月日() {
        return this.entity.getKyuJohoFuyoToYMD();
    }

    /**
     * 国保連データ連携開始年月日を取得します。
     *
     * @return 国保連データ連携開始年月日
     */
    public FlexibleDate get国保連データ連携開始年月日() {
        return this.entity.getKokuhorenDataFromYMD();
    }

    /**
     * 旧市町村コードを取得します。
     *
     * @return 旧市町村コード
     */
    public LasdecCode get旧市町村コード() {
        return this.entity.getKyuShichosonCode();
    }

    /**
     * 加入年月日を取得します。
     *
     * @return 加入年月日
     */
    public FlexibleDate get加入年月日() {
        return this.entity.getKanyuYMD();
    }

    /**
     * 離脱年月日を取得します。
     *
     * @return 離脱年月日
     */
    public FlexibleDate get離脱年月日() {
        return this.entity.getRidatsuYMD();
    }

    /**
     * 旧保険者番号を取得します。
     *
     * @return 旧保険者番号
     */
    public HokenshaNo get旧保険者番号() {
        return this.entity.getKyuHokenshaNo();
    }

    /**
     * 旧市町村名称を取得します。
     *
     * @return 旧市町村名称
     */
    public RString get旧市町村名称() {
        return this.entity.getShichosonMeisho();
    }

    /**
     * 都道府県名称を取得します。
     *
     * @return 都道府県名称
     */
    public RString get都道府県名称() {
        return this.entity.getTodofukenMeisho();
    }

    /**
     * 郡名称を取得します。
     *
     * @return 郡名称
     */
    public RString get郡名称() {
        return this.entity.getGunMeisho();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return this.entity.getYubinNo();
    }

    /**
     * 市町村住所を取得します。
     *
     * @return 市町村住所
     */
    public AtenaJusho get市町村住所() {
        return this.entity.getJusho();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return this.entity.getTelNo();
    }

    /**
     * 老人保健市町村番号を取得します。
     *
     * @return 老人保健市町村番号
     */
    public RString get老人保健市町村番号() {
        return this.entity.getRojinhokenShichosonNo();
    }

    /**
     * 老健受給者番号体系を取得します。
     *
     * @return 老健受給者番号体系
     */
    public RString get老健受給者番号体系() {
        return this.entity.getRokenJukyushaNoTaikei();
    }

    /**
     * 表示有無ﾌﾗｸﾞを取得します。
     *
     * @return 表示有無ﾌﾗｸﾞ
     */
    public RString get表示有無ﾌﾗｸﾞ() {
        return this.entity.getHyojiUmu();
    }

    /**
     * 運用開始日を取得します。
     *
     * @return 運用開始日
     */
    public FlexibleDate get運用開始日() {
        return this.entity.getUnyoKaishiYMD();
    }

    /**
     * 運用終了日を取得します。
     *
     * @return 運用終了日
     */
    public FlexibleDate get運用終了日() {
        return this.entity.getUnyoShuryoYMD();
    }

    /**
     * 運用形態区分を取得します。
     *
     * @return 運用形態区分
     */
    public RString get運用形態区分() {
        return this.entity.getUnyoKeitaiKubun();
    }

    /**
     * 業務共通情報設定します。
     *
     * @param association Association
     */
    public void setCommonInfo(Association association) {

        this.entity.setKyuShichosonCode(new LasdecCode(association.get地方公共団体コード().value()));
        this.entity.setKanyuYMD(FlexibleDate.EMPTY);
        this.entity.setRidatsuYMD(FlexibleDate.EMPTY);
        this.entity.setTodofukenMeisho(association.get都道府県名());
        this.entity.setGunMeisho(association.get郡名());
        this.entity.setJusho(AtenaJusho.EMPTY);
        this.entity.setHyojiUmu(RString.EMPTY);
        this.entity.setUnyoKaishiYMD(FlexibleDate.EMPTY);
        this.entity.setUnyoShuryoYMD(FlexibleDate.EMPTY);
        this.entity.setUnyoKeitaiKubun(RString.EMPTY);
    }
}
