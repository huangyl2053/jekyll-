/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha;

import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * INinshoshaSourceBuilderを生成するクラスです。
 *
 * @author n3309 後藤貴幸
 * @jpName 認証者ソースビルダー作成
 * @bizDomain 業務共通_帳票
 * @category 帳票部品
 * @subCategory 認証者
 * @mainClass
 * @reference
 */
@Deprecated
public class _NinshoshaSourceBuilderCreator implements INinshoshaSourceBuilderCreator {

    private static final int DEFAULT_YAKUSHOKU_MOJI_COUNT = 15;

    @Override
    public INinshoshaSourceBuilder create(GyomuCode gyomuCode, RString shubetsuCode,
            RDate hakkoYMD, Association association, RString imageFolderPath, int yakushokuMojiCount) {

        RDate baseDate = getNowDate(hakkoYMD);
        Ninshosha ninshosha = get認証者(gyomuCode, shubetsuCode, baseDate);
        Association recentAssociation = get地方公共団体(association);

        return NinshoshaSourceBuilderFactory.createInstance(ninshosha, recentAssociation, imageFolderPath, baseDate, yakushokuMojiCount);
    }

    @Override
    public INinshoshaSourceBuilder create(GyomuCode gyomuCode, RString shubetsuCode,
            RDate hakkoYMD, Association association, RString imageFolderPath) {

        RDate baseDate = getNowDate(hakkoYMD);
        Ninshosha ninshosha = get認証者(gyomuCode, shubetsuCode, baseDate);
        Association recentAssociation = get地方公共団体(association);

        return NinshoshaSourceBuilderFactory.createInstance(ninshosha, recentAssociation, imageFolderPath, baseDate, DEFAULT_YAKUSHOKU_MOJI_COUNT);
    }

    @Override
    public INinshoshaSourceBuilder create(GyomuCode gyomuCode, RString shubetsuCode,
            RDate hakkoYMD, RString imageFolderPath, int yakushokuMojiCount) {

        RDate baseDate = getNowDate(hakkoYMD);
        Ninshosha ninshosha = get認証者(gyomuCode, shubetsuCode, baseDate);
        Association recentAssociation = get地方公共団体();

        return NinshoshaSourceBuilderFactory.createInstance(ninshosha, recentAssociation, imageFolderPath, baseDate, yakushokuMojiCount);
    }

    @Override
    public INinshoshaSourceBuilder create(GyomuCode gyomuCode, RString shubetsuCode,
            RDate hakkoYMD, RString imageFolderPath) {

        RDate baseDate = getNowDate(hakkoYMD);
        Ninshosha ninshosha = get認証者(gyomuCode, shubetsuCode, baseDate);
        Association recentAssociation = get地方公共団体();

        return NinshoshaSourceBuilderFactory.createInstance(ninshosha, recentAssociation, imageFolderPath, baseDate, DEFAULT_YAKUSHOKU_MOJI_COUNT);
    }

    private RDate getNowDate(RDate hakkoYMD) {

        if (hakkoYMD != null) {
            return hakkoYMD;
        }

        return RDate.getNowDate();
    }

    private Ninshosha get認証者(GyomuCode gyomuCode, RString shubetsuCode, RDate baseDate) throws IllegalArgumentException {

        Ninshosha ninshosha = NinshoshaFinderFactory
                .createInstance().get帳票認証者(gyomuCode, shubetsuCode, new FlexibleDate(baseDate.toDateString()));

        return ninshosha;
    }

    private Association get地方公共団体() {
        return AssociationFinderFactory.createInstance().getAssociation();
    }

    private Association get地方公共団体(Association association) {

        if (association != null) {
            return association;
        }

        return get地方公共団体();
    }

}
