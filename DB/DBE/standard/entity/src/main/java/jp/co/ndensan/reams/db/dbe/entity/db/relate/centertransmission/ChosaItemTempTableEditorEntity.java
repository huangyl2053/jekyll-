/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;

/**
 * 調査項目一時テーブルのProcessを編集するentityです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class ChosaItemTempTableEditorEntity {

    private static final int 項番3 = 3;
    private static final int 項番4 = 4;
    private static final int 項番5 = 5;
    private static final int 項番6 = 6;
    private static final int 項番7 = 7;
    private static final int 項番8 = 8;
    private static final int 項番9 = 9;
    private static final int 項番10 = 10;
    private static final int 項番11 = 11;
    private static final int 項番12 = 12;
    private static final int 項番13 = 13;
    private static final int 項番14 = 14;
    private static final int 項番15 = 15;
    private static final int 項番16 = 16;
    private static final int 項番17 = 17;
    private static final int 項番18 = 18;
    private static final int 項番19 = 19;
    private static final int 項番20 = 20;
    private static final int 項番21 = 21;
    private static final int 項番22 = 22;
    private static final int 項番23 = 23;
    private static final int 項番24 = 24;
    private static final int 項番25 = 25;
    private static final int 項番26 = 26;
    private static final int 項番27 = 27;
    private static final int 項番28 = 28;
    private static final int 項番29 = 29;
    private static final int 項番30 = 30;
    private static final int 項番31 = 31;
    private static final int 項番32 = 32;
    private static final int 項番33 = 33;
    private static final int 項番34 = 34;
    private static final int 項番35 = 35;
    private static final int 項番36 = 36;
    private static final int 項番37 = 37;
    private static final int 項番38 = 38;
    private static final int 項番39 = 39;
    private static final int 項番40 = 40;
    private static final int 項番41 = 41;
    private static final int 項番42 = 42;
    private static final int 項番43 = 43;
    private static final int 項番44 = 44;
    private static final int 項番45 = 45;
    private static final int 項番46 = 46;
    private static final int 項番47 = 47;
    private static final int 項番48 = 48;
    private static final int 項番49 = 49;
    private static final int 項番50 = 50;
    private static final int 項番51 = 51;
    private static final int 項番52 = 52;
    private static final int 項番53 = 53;
    private static final int 項番54 = 54;
    private static final int 項番55 = 55;
    private static final int 項番56 = 56;
    private static final int 項番57 = 57;
    private static final int 項番58 = 58;
    private static final int 項番59 = 59;
    private static final int 項番60 = 60;
    private static final int 項番61 = 61;
    private static final int 項番62 = 62;
    private static final int 項番63 = 63;
    private static final int 項番64 = 64;
    private static final int 項番65 = 65;
    private static final int 項番66 = 66;
    private static final int 項番67 = 67;
    private static final int 項番68 = 68;
    private static final int 項番69 = 69;
    private static final int 項番70 = 70;
    private static final int 項番71 = 71;
    private static final int 項番72 = 72;
    private static final int 項番73 = 73;
    private static final int 項番74 = 74;
    private static final int 項番75 = 75;
    private static final int 項番76 = 76;
    private static final int 項番77 = 77;
    private static final int 項番78 = 78;
    private static final int 項番79 = 79;
    private static final int 項番80 = 80;
    private static final int 項番81 = 81;
    private static final int 項番82 = 82;
    private static final int 項番83 = 83;
    private static final int 項番84 = 84;
    private static final int 項番85 = 85;
    private final NinteichosahyoChosaItemTempEntity tempEntity;

    /**
     * コンストラクタです。
     *
     * @param entity NinteichosahyoServiceJokyoTempEntity
     */
    public ChosaItemTempTableEditorEntity(NinteichosahyoChosaItemTempEntity entity) {
        this.tempEntity = entity;
    }

    /**
     * 連番でサービスの状況を設定します。
     *
     * @param entity DbT5207NinteichosahyoServiceJokyoEntity
     */
    public void set調査項目(DbT5211NinteichosahyoChosaItemEntity entity) {
        if (entity.getRemban() == 1) {
            tempEntity.setKoban1(entity.getResearchItem());
        } else if (entity.getRemban() == 2) {
            tempEntity.setKoban2(entity.getResearchItem());
        } else if (entity.getRemban() == 項番3) {
            tempEntity.setKoban3(entity.getResearchItem());
        } else if (entity.getRemban() == 項番4) {
            tempEntity.setKoban4(entity.getResearchItem());
        } else if (entity.getRemban() == 項番5) {
            tempEntity.setKoban5(entity.getResearchItem());
        } else if (entity.getRemban() == 項番6) {
            tempEntity.setKoban6(entity.getResearchItem());
        } else if (entity.getRemban() == 項番7) {
            tempEntity.setKoban7(entity.getResearchItem());
        } else if (entity.getRemban() == 項番8) {
            tempEntity.setKoban8(entity.getResearchItem());
        } else if (entity.getRemban() == 項番9) {
            tempEntity.setKoban9(entity.getResearchItem());
        } else if (entity.getRemban() == 項番10) {
            tempEntity.setKoban10(entity.getResearchItem());
        } else {
            set調査項目By連番10以降(entity);
        }
    }

    private void set調査項目By連番10以降(DbT5211NinteichosahyoChosaItemEntity entity) {
        if (entity.getRemban() == 項番11) {
            tempEntity.setKoban11(entity.getResearchItem());
        } else if (entity.getRemban() == 項番12) {
            tempEntity.setKoban12(entity.getResearchItem());
        } else if (entity.getRemban() == 項番13) {
            tempEntity.setKoban13(entity.getResearchItem());
        } else if (entity.getRemban() == 項番14) {
            tempEntity.setKoban14(entity.getResearchItem());
        } else if (entity.getRemban() == 項番15) {
            tempEntity.setKoban15(entity.getResearchItem());
        } else if (entity.getRemban() == 項番16) {
            tempEntity.setKoban16(entity.getResearchItem());
        } else if (entity.getRemban() == 項番17) {
            tempEntity.setKoban17(entity.getResearchItem());
        } else if (entity.getRemban() == 項番18) {
            tempEntity.setKoban18(entity.getResearchItem());
        } else if (entity.getRemban() == 項番19) {
            tempEntity.setKoban19(entity.getResearchItem());
        } else if (entity.getRemban() == 項番20) {
            tempEntity.setKoban20(entity.getResearchItem());
        } else {
            set調査項目By連番20以降(entity);
        }
    }

    private void set調査項目By連番20以降(DbT5211NinteichosahyoChosaItemEntity entity) {
        if (entity.getRemban() == 項番21) {
            tempEntity.setKoban21(entity.getResearchItem());
        } else if (entity.getRemban() == 項番22) {
            tempEntity.setKoban22(entity.getResearchItem());
        } else if (entity.getRemban() == 項番23) {
            tempEntity.setKoban23(entity.getResearchItem());
        } else if (entity.getRemban() == 項番24) {
            tempEntity.setKoban24(entity.getResearchItem());
        } else if (entity.getRemban() == 項番25) {
            tempEntity.setKoban25(entity.getResearchItem());
        } else if (entity.getRemban() == 項番26) {
            tempEntity.setKoban26(entity.getResearchItem());
        } else if (entity.getRemban() == 項番27) {
            tempEntity.setKoban27(entity.getResearchItem());
        } else if (entity.getRemban() == 項番28) {
            tempEntity.setKoban28(entity.getResearchItem());
        } else if (entity.getRemban() == 項番29) {
            tempEntity.setKoban29(entity.getResearchItem());
        } else if (entity.getRemban() == 項番30) {
            tempEntity.setKoban30(entity.getResearchItem());
        } else {
            set調査項目By連番30以降(entity);
        }
    }

    private void set調査項目By連番30以降(DbT5211NinteichosahyoChosaItemEntity entity) {
        if (entity.getRemban() == 項番31) {
            tempEntity.setKoban31(entity.getResearchItem());
        } else if (entity.getRemban() == 項番32) {
            tempEntity.setKoban32(entity.getResearchItem());
        } else if (entity.getRemban() == 項番33) {
            tempEntity.setKoban33(entity.getResearchItem());
        } else if (entity.getRemban() == 項番34) {
            tempEntity.setKoban34(entity.getResearchItem());
        } else if (entity.getRemban() == 項番35) {
            tempEntity.setKoban35(entity.getResearchItem());
        } else if (entity.getRemban() == 項番36) {
            tempEntity.setKoban36(entity.getResearchItem());
        } else if (entity.getRemban() == 項番37) {
            tempEntity.setKoban37(entity.getResearchItem());
        } else if (entity.getRemban() == 項番38) {
            tempEntity.setKoban38(entity.getResearchItem());
        } else if (entity.getRemban() == 項番39) {
            tempEntity.setKoban39(entity.getResearchItem());
        } else if (entity.getRemban() == 項番40) {
            tempEntity.setKoban40(entity.getResearchItem());
        } else {
            set調査項目By連番40以降(entity);
        }
    }

    private void set調査項目By連番40以降(DbT5211NinteichosahyoChosaItemEntity entity) {
        if (entity.getRemban() == 項番41) {
            tempEntity.setKoban41(entity.getResearchItem());
        } else if (entity.getRemban() == 項番42) {
            tempEntity.setKoban42(entity.getResearchItem());
        } else if (entity.getRemban() == 項番43) {
            tempEntity.setKoban43(entity.getResearchItem());
        } else if (entity.getRemban() == 項番44) {
            tempEntity.setKoban44(entity.getResearchItem());
        } else if (entity.getRemban() == 項番45) {
            tempEntity.setKoban45(entity.getResearchItem());
        } else if (entity.getRemban() == 項番46) {
            tempEntity.setKoban46(entity.getResearchItem());
        } else if (entity.getRemban() == 項番47) {
            tempEntity.setKoban47(entity.getResearchItem());
        } else if (entity.getRemban() == 項番48) {
            tempEntity.setKoban48(entity.getResearchItem());
        } else if (entity.getRemban() == 項番49) {
            tempEntity.setKoban49(entity.getResearchItem());
        } else if (entity.getRemban() == 項番50) {
            tempEntity.setKoban50(entity.getResearchItem());
        } else {
            set調査項目By連番50以降(entity);
        }
    }

    private void set調査項目By連番50以降(DbT5211NinteichosahyoChosaItemEntity entity) {
        if (entity.getRemban() == 項番51) {
            tempEntity.setKoban51(entity.getResearchItem());
        } else if (entity.getRemban() == 項番52) {
            tempEntity.setKoban52(entity.getResearchItem());
        } else if (entity.getRemban() == 項番53) {
            tempEntity.setKoban53(entity.getResearchItem());
        } else if (entity.getRemban() == 項番54) {
            tempEntity.setKoban54(entity.getResearchItem());
        } else if (entity.getRemban() == 項番55) {
            tempEntity.setKoban55(entity.getResearchItem());
        } else if (entity.getRemban() == 項番56) {
            tempEntity.setKoban56(entity.getResearchItem());
        } else if (entity.getRemban() == 項番57) {
            tempEntity.setKoban57(entity.getResearchItem());
        } else if (entity.getRemban() == 項番58) {
            tempEntity.setKoban58(entity.getResearchItem());
        } else if (entity.getRemban() == 項番59) {
            tempEntity.setKoban59(entity.getResearchItem());
        } else if (entity.getRemban() == 項番60) {
            tempEntity.setKoban60(entity.getResearchItem());
        } else {
            set調査項目By連番60以降(entity);
        }
    }

    private void set調査項目By連番60以降(DbT5211NinteichosahyoChosaItemEntity entity) {
        if (entity.getRemban() == 項番61) {
            tempEntity.setKoban61(entity.getResearchItem());
        } else if (entity.getRemban() == 項番62) {
            tempEntity.setKoban62(entity.getResearchItem());
        } else if (entity.getRemban() == 項番63) {
            tempEntity.setKoban63(entity.getResearchItem());
        } else if (entity.getRemban() == 項番64) {
            tempEntity.setKoban64(entity.getResearchItem());
        } else if (entity.getRemban() == 項番65) {
            tempEntity.setKoban65(entity.getResearchItem());
        } else if (entity.getRemban() == 項番66) {
            tempEntity.setKoban66(entity.getResearchItem());
        } else if (entity.getRemban() == 項番67) {
            tempEntity.setKoban67(entity.getResearchItem());
        } else if (entity.getRemban() == 項番68) {
            tempEntity.setKoban68(entity.getResearchItem());
        } else if (entity.getRemban() == 項番69) {
            tempEntity.setKoban69(entity.getResearchItem());
        } else if (entity.getRemban() == 項番70) {
            tempEntity.setKoban70(entity.getResearchItem());
        } else {
            set調査項目By連番70以降(entity);
        }
    }

    private void set調査項目By連番70以降(DbT5211NinteichosahyoChosaItemEntity entity) {
        if (entity.getRemban() == 項番71) {
            tempEntity.setKoban71(entity.getResearchItem());
        } else if (entity.getRemban() == 項番72) {
            tempEntity.setKoban72(entity.getResearchItem());
        } else if (entity.getRemban() == 項番73) {
            tempEntity.setKoban73(entity.getResearchItem());
        } else if (entity.getRemban() == 項番74) {
            tempEntity.setKoban74(entity.getResearchItem());
        } else if (entity.getRemban() == 項番75) {
            tempEntity.setKoban75(entity.getResearchItem());
        } else if (entity.getRemban() == 項番76) {
            tempEntity.setKoban76(entity.getResearchItem());
        } else if (entity.getRemban() == 項番77) {
            tempEntity.setKoban77(entity.getResearchItem());
        } else if (entity.getRemban() == 項番78) {
            tempEntity.setKoban78(entity.getResearchItem());
        } else if (entity.getRemban() == 項番79) {
            tempEntity.setKoban79(entity.getResearchItem());
        } else if (entity.getRemban() == 項番80) {
            tempEntity.setKoban80(entity.getResearchItem());
        } else if (entity.getRemban() == 項番81) {
            tempEntity.setKoban81(entity.getResearchItem());
        } else if (entity.getRemban() == 項番82) {
            tempEntity.setKoban82(entity.getResearchItem());
        } else if (entity.getRemban() == 項番83) {
            tempEntity.setKoban83(entity.getResearchItem());
        } else if (entity.getRemban() == 項番84) {
            tempEntity.setKoban84(entity.getResearchItem());
        } else if (entity.getRemban() == 項番85) {
            tempEntity.setKoban85(entity.getResearchItem());
        }
    }

}
