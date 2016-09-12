/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshojohoprint;

import jp.co.ndensan.reams.db.dbe.business.core.shijiiikenshoiraihen.ShijiiIkenshoIraiHenko;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojohoprint.IkenshoJohoPrintRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikensho5komoku.ShujiiIkensho5komokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoiraisumi.ShujiiIkenshoIraiSumiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshomiirai.ShujiiIkenshoMiIraiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshomiteishutsu.ShujiiIkenshoMiteishutsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 意見書情報印刷のBusinessクラスです。
 *
 * @reamsid_L DBE-1390-090 lijia
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoJohoPrintBusiness {

    private int indexTmp;
    private int index;
    private ShijiiIkenshoIraiHenko shijiiIkenshoIraiHenko;

    /**
     * 主治医意見書依頼未処理者一覧情報を設定します。
     *
     * @param entity IkenshoJohoPrintRelateEntity
     * @return ShujiiIkenshoMiIraiEntity
     */
    public ShujiiIkenshoMiIraiEntity toShujiiIkenshoMiIraiEntity(IkenshoJohoPrintRelateEntity entity) {
        ShujiiIkenshoMiIraiEntity shujiiIkenshoMiIraiEntity = new ShujiiIkenshoMiIraiEntity();
        shujiiIkenshoMiIraiEntity.set保険者番号(entity.getShoKisaiHokenshaNo());
        shujiiIkenshoMiIraiEntity.set保険者名(entity.getShichosonMeisho());
        shujiiIkenshoMiIraiEntity.set氏名(entity.getHihokenshaName());
        shujiiIkenshoMiIraiEntity.set被保険者番号(entity.getHihokenshaNo());
        shujiiIkenshoMiIraiEntity.set生年月日(entity.getSeinengappiYMD());
        shujiiIkenshoMiIraiEntity.set性別(entity.getSeibetsu().getColumnValue());
        shujiiIkenshoMiIraiEntity.set認定申請年月日(entity.getNinteiShinseiYMD());
        Code 認定申請区分 = entity.getNinteiShinseiShinseijiKubunCode();
        shujiiIkenshoMiIraiEntity.set認定申請区分申請時コード(認定申請区分 == null ? RString.EMPTY : 認定申請区分.getColumnValue());
        shujiiIkenshoMiIraiEntity.set前前回医療機関(entity.getIryoKikanMeisho3());
        shujiiIkenshoMiIraiEntity.set前前回主治医(entity.getShujiiName3());
        shujiiIkenshoMiIraiEntity.set前回医療機関(entity.getIryoKikanMeisho2());
        shujiiIkenshoMiIraiEntity.set前回主治医(entity.getShujiiName2());
        shujiiIkenshoMiIraiEntity.set今回医療機関(entity.getIryoKikanMeisho());
        shujiiIkenshoMiIraiEntity.set今回主治医(entity.getShujiiName());
        return shujiiIkenshoMiIraiEntity;
    }

    /**
     * 主治医意見書作成依頼変更者一覧情報を設定します。
     *
     * @param before IkenshoJohoPrintRelateEntity
     * @param entity IkenshoJohoPrintRelateEntity
     * @param count 件数
     * @return ShijiiIkenshoIraiHenko
     */
    public ShijiiIkenshoIraiHenko toShijiiIkenshoIraiHenko(IkenshoJohoPrintRelateEntity before, IkenshoJohoPrintRelateEntity entity, int count) {
        if (before == null) {
            return null;
        }
        index++;
        if (before.getShinseishoKanriNo().equals(entity.getShinseishoKanriNo())) {
            if (entity.getIkenshoIraiRirekiNo() > 1) {
                indexTmp++;
                shijiiIkenshoIraiHenko = new ShijiiIkenshoIraiHenko();
                shijiiIkenshoIraiHenko.set保険者番号(entity.getShoKisaiHokenshaNo());
                shijiiIkenshoIraiHenko.set保険者名(entity.getShichosonMeisho());
                shijiiIkenshoIraiHenko.set氏名(entity.getHihokenshaName());
                shijiiIkenshoIraiHenko.set被保険者番号(entity.getHihokenshaNo());
                shijiiIkenshoIraiHenko.set生年月日(entity.getSeinengappiYMD());
                shijiiIkenshoIraiHenko.set性別(entity.getSeibetsu().getColumnValue());
                shijiiIkenshoIraiHenko.set認定申請年月日(entity.getNinteiShinseiYMD());
                Code 認定申請区分 = entity.getNinteiShinseiShinseijiKubunCode();
                shijiiIkenshoIraiHenko.set認定申請区分申請時コード(認定申請区分 == null ? RString.EMPTY : 認定申請区分.getColumnValue());
                shijiiIkenshoIraiHenko.set変更回数(indexTmp);
                shijiiIkenshoIraiHenko.set変更前医療機関(before.getIryoKikanMeisho());
                shijiiIkenshoIraiHenko.set変更前主治医(before.getShujiiName());
                shijiiIkenshoIraiHenko.set変更後医療機関(entity.getIryoKikanMeisho());
                shijiiIkenshoIraiHenko.set変更後主治医(entity.getShujiiName());
                shijiiIkenshoIraiHenko.set変更日(entity.getIkenshoSakuseiIraiYMD());
            }
            if (index == count && indexTmp > 0) {
                indexTmp = 0;
                return shijiiIkenshoIraiHenko;
            }
        } else {
            if (indexTmp > 0) {
                indexTmp = 0;
                return shijiiIkenshoIraiHenko;
            }
        }
        return null;
    }

    /**
     * 主治医意見書未提出者一覧情報を設定します。
     *
     * @param entity IkenshoJohoPrintRelateEntity
     * @return ShujiiIkenshoMiteishutsuEntity
     */
    public ShujiiIkenshoMiteishutsuEntity toShujiiIkenshoMiteishutsuEntity(IkenshoJohoPrintRelateEntity entity) {
        ShujiiIkenshoMiteishutsuEntity shujiiIkenshoMiteishutsuEntity = new ShujiiIkenshoMiteishutsuEntity();
        shujiiIkenshoMiteishutsuEntity.set保険者番号(entity.getShoKisaiHokenshaNo());
        shujiiIkenshoMiteishutsuEntity.set保険者名(entity.getShichosonMeisho());
        shujiiIkenshoMiteishutsuEntity.set氏名(entity.getHihokenshaName());
        shujiiIkenshoMiteishutsuEntity.set被保険者番号(entity.getHihokenshaNo());
        shujiiIkenshoMiteishutsuEntity.set生年月日(entity.getSeinengappiYMD());
        shujiiIkenshoMiteishutsuEntity.set性別(entity.getSeibetsu().getColumnValue());
        shujiiIkenshoMiteishutsuEntity.set申請日(entity.getNinteiShinseiYMD());
        Code 認定申請区分 = entity.getNinteiShinseiShinseijiKubunCode();
        shujiiIkenshoMiteishutsuEntity.set申請区分(認定申請区分 == null ? RString.EMPTY : 認定申請区分.getColumnValue());
        shujiiIkenshoMiteishutsuEntity.set医療機関(entity.getIryoKikanMeisho());
        shujiiIkenshoMiteishutsuEntity.set主治医(entity.getShujiiName());
        shujiiIkenshoMiteishutsuEntity.set依頼日(entity.getIkenshoSakuseiIraiYMD());
        shujiiIkenshoMiteishutsuEntity.set入手予定日(entity.getIkenshoSakuseiIraiYoteiYMD());
        shujiiIkenshoMiteishutsuEntity.set直近督促日(entity.getIkenshoSakuseiTokusokuYMD());
        if (entity.getIkenshoTokusokuKaisu() != null) {
            shujiiIkenshoMiteishutsuEntity.set督促回数(Integer.parseInt(entity.getIkenshoTokusokuKaisu().toString()));
        }
        return shujiiIkenshoMiteishutsuEntity;
    }

    /**
     * 主治医意見書依頼済み一覧情報を設定します。
     *
     * @param entity IkenshoJohoPrintRelateEntity
     * @return ShujiiIkenshoIraiSumiEntity
     */
    public ShujiiIkenshoIraiSumiEntity toShujiiIkenshoIraiSumiEntity(IkenshoJohoPrintRelateEntity entity) {
        ShujiiIkenshoIraiSumiEntity shujiiIkenshoIraiSumiEntity = new ShujiiIkenshoIraiSumiEntity();
        shujiiIkenshoIraiSumiEntity.set保険者番号(entity.getShoKisaiHokenshaNo());
        shujiiIkenshoIraiSumiEntity.set保険者名(entity.getShichosonMeisho());
        shujiiIkenshoIraiSumiEntity.set氏名(entity.getHihokenshaName());
        shujiiIkenshoIraiSumiEntity.set被保険者番号(entity.getHihokenshaNo());
        shujiiIkenshoIraiSumiEntity.set生年月日(entity.getSeinengappiYMD());
        shujiiIkenshoIraiSumiEntity.set性別(entity.getSeibetsu().getColumnValue());
        shujiiIkenshoIraiSumiEntity.set認定申請年月日(entity.getNinteiShinseiYMD());
        Code 認定申請区分 = entity.getNinteiShinseiShinseijiKubunCode();
        shujiiIkenshoIraiSumiEntity.set認定申請区分申請時コード(認定申請区分 == null ? RString.EMPTY : 認定申請区分.getColumnValue());
        shujiiIkenshoIraiSumiEntity.set医療機関(entity.getIryoKikanMeisho());
        shujiiIkenshoIraiSumiEntity.set主治医(entity.getShujiiName());
        shujiiIkenshoIraiSumiEntity.set依頼日(entity.getIkenshoSakuseiIraiYMD());
        shujiiIkenshoIraiSumiEntity.set作成期限(entity.getIkenshoSakuseiKigenYMD());
        shujiiIkenshoIraiSumiEntity.set依頼書出力年月日(entity.getIraishoShutsuryokuYMD());
        shujiiIkenshoIraiSumiEntity.set意見書出力年月日(entity.getIkenshoShutsuryokuYMD());
        shujiiIkenshoIraiSumiEntity.set請求書出力年月日(entity.getSeikyushoShutsuryokuYMD());
        return shujiiIkenshoIraiSumiEntity;
    }

    /**
     * 主治医意見書5項目確認一覧情報を設定します。
     *
     * @param entity IkenshoJohoPrintRelateEntity
     * @return ShujiiIkensho5komokuEntity
     */
    public ShujiiIkensho5komokuEntity toShujiiIkensho5komokuEntity(IkenshoJohoPrintRelateEntity entity) {
        ShujiiIkensho5komokuEntity shujiiIkensho5komokuEntity = new ShujiiIkensho5komokuEntity();
        shujiiIkensho5komokuEntity.set保険者番号(entity.getShoKisaiHokenshaNo());
        shujiiIkensho5komokuEntity.set保険者名(entity.getShichosonMeisho());
        shujiiIkensho5komokuEntity.set氏名(entity.getHihokenshaName());
        shujiiIkensho5komokuEntity.set被保険者番号(entity.getHihokenshaNo());
        shujiiIkensho5komokuEntity.set生年月日(entity.getSeinengappiYMD());
        shujiiIkensho5komokuEntity.set性別(entity.getSeibetsu().getColumnValue());
        shujiiIkensho5komokuEntity.set認定申請年月日(entity.getNinteiShinseiYMD());
        Code 認定申請区分 = entity.getNinteiShinseiShinseijiKubunCode();
        shujiiIkensho5komokuEntity.set認定申請区分申請時コード(認定申請区分 == null ? RString.EMPTY : 認定申請区分.getColumnValue());
        shujiiIkensho5komokuEntity.set意見書連番(entity.getRemban());
        shujiiIkensho5komokuEntity.set意見項目(entity.getIkenItem());
        Code 厚労省IF識別コード = entity.getKoroshoIfShikibetsuCode();
        shujiiIkensho5komokuEntity.set厚労省IF識別コード(
                厚労省IF識別コード == null ? RString.EMPTY : 厚労省IF識別コード.getColumnValue());
        return shujiiIkensho5komokuEntity;
    }

    /**
     * 主治医意見書作成料請求一覧情報を設定します。
     *
     * @param entity IkenshoJohoPrintRelateEntity
     * @return ShujiiIkenshoSeikyuIchiranEntity
     */
    public ShujiiIkenshoSeikyuIchiranEntity toShujiiIkenshoSeikyuIchiranEntity(IkenshoJohoPrintRelateEntity entity) {
        ShujiiIkenshoSeikyuIchiranEntity shujiiIkenshoSeikyuEntity = new ShujiiIkenshoSeikyuIchiranEntity();
        shujiiIkenshoSeikyuEntity.set保険者番号(entity.getShoKisaiHokenshaNo());
        shujiiIkenshoSeikyuEntity.set保険者名(entity.getShichosonMeisho());
        shujiiIkenshoSeikyuEntity.set氏名(entity.getHihokenshaName());
        shujiiIkenshoSeikyuEntity.set被保険者番号(entity.getHihokenshaNo());
        shujiiIkenshoSeikyuEntity.set生年月日(entity.getSeinengappiYMD());
        shujiiIkenshoSeikyuEntity.set性別(entity.getSeibetsu().getColumnValue());
        shujiiIkenshoSeikyuEntity.set認定申請年月日(entity.getNinteiShinseiYMD());
        Code 認定申請区分 = entity.getNinteiShinseiShinseijiKubunCode();
        shujiiIkenshoSeikyuEntity.set認定申請区分申請時コード(認定申請区分 == null ? RString.EMPTY : 認定申請区分.getColumnValue());
        shujiiIkenshoSeikyuEntity.set医療機関(entity.getIryoKikanMeisho());
        shujiiIkenshoSeikyuEntity.set主治医意見書受領年月日(entity.getIkenshoJuryoYMD());
        shujiiIkenshoSeikyuEntity.set主治医意見書記入年月日(entity.getIkenshoKinyuYMD());
        shujiiIkenshoSeikyuEntity.set主治医意見書読取年月日(entity.getIkenshoReadYMD());
        shujiiIkenshoSeikyuEntity.set主治医意見書作成料(entity.getIkenshoSakuseiryo());
        shujiiIkenshoSeikyuEntity.set主治医意見書別途診療費(entity.getIkenshoBettoShinryohi());
        shujiiIkenshoSeikyuEntity.set報酬支払年月日(entity.getHoshuShiharaiYMD());
        return shujiiIkenshoSeikyuEntity;
    }

}
