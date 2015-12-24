/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.gappeijoho;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.GappeiJyohoEntity;
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
public class GappeiJyoho {

    private GappeiJyohoEntity entity;

    private GappeiJyoho() {

    }

    /**
     * DBより取得した{@link KaokuSearchResultEntity}より{@link KaokuSearchResult}を生成します。
     *
     * @param entity KaokuSearchResultEntity
     */
    public GappeiJyoho(GappeiJyohoEntity entity) {
        this.entity = Objects.requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合併市町村情報検索結果"));
    }

    /**
     * 合併情報番号を返す
     *
     * @return 合併情報番号
     */
    public RString get合併情報番号() {
        return this.entity.getChiikiNo();
    }

    /**
     * 合併種類を返す
     *
     * @return 合併種類
     */
    public RString get合併種類() {
        return this.entity.getGappeiShurui();
    }

    /**
     * 合併日を返す
     *
     * @return 合併日
     */
    public FlexibleDate get合併日() {
        return this.entity.getGappeiYMD();
    }

    /**
     * 市町村コードを返す
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return this.entity.getShichosonCode();
    }

    /**
     * 保険者番号を返す
     *
     * @return 保険者番号
     */
    public ShoKisaiHokenshaNo get保険者番号() {
        return this.entity.getHokenshaNo();
    }

    /**
     * 旧市町村情報付与終了年月日を返す
     *
     * @return 旧市町村情報付与終了年月日
     */
    public FlexibleDate get旧市町村情報付与終了年月日() {
        return this.entity.getKyuJohoFuyoToYMD();
    }

    /**
     * 国保連データ連携開始年月日を返す
     *
     * @return 国保連データ連携開始年月日
     */
    public FlexibleDate get国保連データ連携開始年月日() {
        return this.entity.getKokuhorenDataFromYMD();
    }

    /**
     * 旧市町村コードを返す
     *
     * @return 旧市町村コード
     */
    public LasdecCode get旧市町村コード() {
        return this.entity.getKyuShichosonCode();
    }

    /**
     * 加入年月日を返す
     *
     * @return 加入年月日
     */
    public FlexibleDate get加入年月日() {
        return this.entity.getKanyuYMD();
    }

    /**
     * 離脱年月日を返す
     *
     * @return 離脱年月日
     */
    public FlexibleDate get離脱年月日() {
        return this.entity.getRidatsuYMD();
    }

    /**
     * 旧保険者番号を返す
     *
     * @return 旧保険者番号
     */
    public ShoKisaiHokenshaNo get旧保険者番号() {
        return this.entity.getKyuHokenshaNo();
    }

    /**
     * 旧市町村名称を返す
     *
     * @return 旧市町村名称
     */
    public RString get旧市町村名称() {
        return this.entity.getShichosonMeisho();
    }

    /**
     * 都道府県名称を返す
     *
     * @return 都道府県名称
     */
    public RString get都道府県名称() {
        return this.entity.getTodofukenMeisho();
    }

    /**
     * 郡名称を返す
     *
     * @return 郡名称
     */
    public RString get郡名称() {
        return this.entity.getGunMeisho();
    }

    /**
     * 郵便番号を返す
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return this.entity.getYubinNo();
    }

    /**
     * 市町村住所を返す
     *
     * @return 市町村住所
     */
    public AtenaJusho get市町村住所() {
        return this.entity.getJusho();
    }

    /**
     * 電話番号を返す
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return this.entity.getTelNo();
    }

    /**
     * 老人保健市町村番号を返す
     *
     * @return 老人保健市町村番号
     */
    public RString get老人保健市町村番号() {
        return this.entity.getRojinhokenShichosonNo();
    }

    /**
     * 老健受給者番号体系を返す
     *
     * @return 老健受給者番号体系
     */
    public RString get老健受給者番号体系() {
        return this.entity.getRokenJukyushaNoTaikei();
    }

    /**
     * 表示有無ﾌﾗｸﾞを返す
     *
     * @return 表示有無ﾌﾗｸﾞ
     */
    public RString get表示有無ﾌﾗｸﾞ() {
        return this.entity.getHyojiUmu();
    }

    /**
     * 運用開始日を返す
     *
     * @return 運用開始日
     */
    public FlexibleDate get運用開始日() {
        return this.entity.getUnyoKaishiYMD();
    }

    /**
     * 運用終了日を返す
     *
     * @return 運用終了日
     */
    public FlexibleDate get運用終了日() {
        return this.entity.getUnyoShuryoYMD();
    }

    /**
     * 運用形態区分を返す
     *
     * @return 運用形態区分
     */
    public RString get運用形態区分() {
        return this.entity.getUnyoKeitaiKubun();
    }

    /**
     * 業務共通情報設定
     *
     * @param association 地方公共団体
     * @deprecated このメソッドは互換性のために残してあります。実装指針と異なるため削除予定です。
     */
    @Deprecated
    public void setCommonInfo(Association association) {

        // 業務共通（ZR）導入団体クラスの市町村コード
        this.entity.setShichosonCode(association.get地方公共団体コード());
        // 加入年月日 ''
        this.entity.setKanyuYMD(FlexibleDate.EMPTY);
        // 離脱年月日 ''
        this.entity.setRidatsuYMD(FlexibleDate.EMPTY);
        // 業務共通（ZR）導入団体クラスの都道府県名称
        this.entity.setTodofukenMeisho(association.get都道府県名());
        // 業務共通（ZR）導入団体クラスの郡名称
        this.entity.setGunMeisho(association.get郡名());
        // 市町村住所
        this.entity.setJusho(AtenaJusho.EMPTY);
        // 表示有無ﾌﾗｸ ''
        this.entity.setHyojiUmu(RString.EMPTY);
        // 運用開始日 ''
        this.entity.setUnyoKaishiYMD(FlexibleDate.EMPTY);
        // 運用終了日 ''
        this.entity.setUnyoShuryoYMD(FlexibleDate.EMPTY);
        // 運用形態区分 ''
        this.entity.setUnyoKeitaiKubun(RString.EMPTY);
    }
}
