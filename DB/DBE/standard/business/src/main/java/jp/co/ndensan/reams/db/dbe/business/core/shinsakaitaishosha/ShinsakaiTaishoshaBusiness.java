/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaitaishosha;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaitaishosha.ShinsakaiTaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会個人別状況照会のBusinessです。
 *
 * @reamsid_L DBE-1380-010 jinjue
 */
public class ShinsakaiTaishoshaBusiness {

    private final ShinsakaiTaishoshaRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 審査会個人別状況照会Entity
     */
    public ShinsakaiTaishoshaBusiness(ShinsakaiTaishoshaRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護認定審査会開催番号を取得します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString getShinsakaiKaisaiNo() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 合議体名称を取得します。
     *
     * @return 合議体名称
     */
    public RString getGogitaiMei() {
        return entity.getGogitaiMei();
    }

    /**
     * 介護認定審査会予定定員を取得します。
     *
     * @return 介護認定審査会予定定員
     */
    public int getShinsakaiYoteiTeiin() {
        return entity.getShinsakaiYoteiTeiin();
    }

    /**
     * 介護認定審査会割当済み人数を取得します。
     *
     * @return 介護認定審査会割当済み人数
     */
    public int getShinsakaiWariateZumiNinzu() {
        return entity.getShinsakaiWariateZumiNinzu();
    }

    /**
     * 介護認定審査会進捗状況を取得します。
     *
     * @return 介護認定審査会進捗状況
     */
    public Code getShinsakaiShinchokuJokyo() {
        return entity.getShinsakaiShinchokuJokyo();
    }

    /**
     * 介護認定審査会開催場所名称を取得します。
     *
     * @return 介護認定審査会開催場所名称
     */
    public RString getShinsakaiKaisaiBashoName() {
        return entity.getShinsakaiKaisaiBashoName();
    }

    /**
     * 介護認定審査会開催場所コードを取得します。
     *
     * @return 介護認定審査会開催場所
     */
    public RString getShinsakaiKaisaiBashoCode() {
        return entity.getShinsakaiKaisaiBashoCode();
    }

    /**
     * 介護認定審査会開催予定年月日を取得します。
     *
     * @return 介護認定審査会開催予定年月日
     */
    public FlexibleDate getShinsakaiKaisaiYoteiYMD() {
        return entity.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 介護認定審査会開始予定時刻を取得します。
     *
     * @return 介護認定審査会開始予定時刻
     */
    public RString getShinsakaiKaishiYoteiTime() {
        return entity.getShinsakaiKaishiYoteiTime();
    }

    /**
     * 介護認定審査会終了予定時刻を取得します。
     *
     * @return 介護認定審査会終了予定時刻
     */
    public RString getShinsakaiShuryoYoteiTime() {
        return entity.getShinsakaiShuryoYoteiTime();
    }

    /**
     * 審査会種類を取得します。
     *
     * @return 審査会種類
     */
    public boolean isGogitaiSeishinkaSonzaiFlag() {
        return entity.isGogitaiSeishinkaSonzaiFlag();

    }

    /**
     * 開催日を取得します。
     *
     * @return 開催日
     */
    public FlexibleDate getShinsakaiKaisaiYMD() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 開始時間を取得します。
     *
     * @return 開始時間
     */
    public RString getShinsakaiKaishiTime() {
        return entity.getShinsakaiKaishiTime();
    }

    /**
     * 終了時間を取得します。
     *
     * @return 終了時間
     */
    public RString getShinsakaiShuryoTime() {
        return entity.getShinsakaiShuryoTime();
    }

    /**
     * 所要時間を取得します。
     *
     * @return 所要時間
     */
    public int getShoyoJikanGokei() {
        return entity.getShoyoJikanGokei();
    }

    /**
     * 実施人数を取得します。
     *
     * @return 実施人数
     */
    public int getShinsakaiJisshiNinzu() {
        return entity.getShinsakaiJisshiNinzu();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public RString getShoKisaiHokenshaNo() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString getHihokenshaNo() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho getHihokenshaName() {
        return entity.getHihokenshaName();
    }

    /**
     * 性別コードを取得します。
     *
     * @return 性別コード
     */
    public Code getSeibetsu() {
        return entity.getSeibetsu();
    }

    /**
     * 被保険者区分コードを取得します。
     *
     * @return 被保険者区分コード
     */
    public RString getHihokenshaKubunCode() {
        return entity.getHihokenshaKubunCode();
    }

    /**
     * 二次判定要介護状態区分コードを取得します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public Code getNijiHanteiYokaigoJotaiKubunCode() {
        return entity.getNijiHanteiYokaigoJotaiKubunCode();
    }

    /**
     * 認定申請日を取得します。
     *
     * @return 認定申請日
     */
    public FlexibleDate getNinteiShinseiYMD() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 市町村名称を取得します。
     *
     * @return 市町村名称
     */
    public RString getShichosonMeisho() {
        return entity.getShichosonMeisho();
    }

    /**
     * 介護認定審査会審査順を取得します。
     *
     * @return 介護認定審査会審査順
     */
    public int getShinsakaiOrder() {
        return entity.getShinsakaiOrder();
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 再調査依頼回数を取得します。
     *
     * @return 再調査依頼回数
     */
    public int getSaiChosaIraiKaisu() {
        return entity.getSaiChosaIraiKaisu();
    }

    /**
     * 再作成依頼回数を取得します。
     *
     * @return 再作成依頼回数
     */
    public int getSaiSakuseiIraiKaisu() {
        return entity.getSaiSakuseiIraiKaisu();
    }

    /**
     * 要介護認定一次判定結果コードを取得します。
     *
     * @return 要介護認定一次判定結果コード
     */
    public Code getIchijiHanteiKekkaCode() {
        return entity.getIchijiHanteiKekkaCode();
    }

    /**
     * 障害高齢者の日常生活自立度コードを取得します。
     *
     * @return 障害高齢者の日常生活自立度コード
     */
    public Code getShogaiNichijoSeikatsuJiritsudoCode() {
        return entity.getShogaiNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 認知症高齢者の日常生活自立度コードを取得します。
     *
     * @return 認知症高齢者の日常生活自立度コード
     */
    public Code ninchishoNichijoSeikatsuJiritsudoCode() {
        return entity.getNinchishoNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 調査機関の事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public RString getJigyoshaMeisho() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 調査員の氏名を取得します。
     *
     * @return 調査員氏名
     */
    public RString getChosainShimei() {
        return entity.getChosainShimei();
    }

    /**
     * 再調査依頼回数を取得します。
     *
     * @return 再調査依頼回数
     */
    public RString getIryoKikanMeisho() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * .医療機関名称を取得します。
     *
     * @return .医療機関名称
     */
    public RString getShujiiName() {
        return entity.getShujiiName();
    }

    /**
     * 認知症高齢者自立度コードを取得します。
     *
     * @return 認知症高齢者自立度コード
     */
    public Code getNinchishoNichijoSeikatsuJiritsudoCode() {
        return entity.getNinchishoNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 申請区分(申請時)コードを取得します。
     *
     * @return 申請区分コード
     */
    public Code getNinteiShinseiShinseijiKubunCode() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 介護認定審査会開催地区コードを取得します。
     *
     * @return 介護認定審査会開催地区コード
     */
    public Code getShinsakaiKaisaiChikuCode() {
        return entity.getShinsakaiKaisaiChikuCode();
    }
}
