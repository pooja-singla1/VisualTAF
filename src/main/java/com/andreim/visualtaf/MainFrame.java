/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreim.visualtaf;

import static com.andreim.visualtaf.App.doc;
import static com.andreim.visualtaf.App.enTestsToRun;
import static com.andreim.visualtaf.App.htmlReport;
import static com.andreim.visualtaf.App.lmc;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FilenameUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Andrei
 */
public class MainFrame extends javax.swing.JFrame {

    public static DefaultMutableTreeNode lastSelectedNode;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        java.net.URL url = ClassLoader.getSystemResource("icon.png");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        setIconImage(img);

        try (FileInputStream fis = new FileInputStream("data.ser");
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            jTree1.setModel((DefaultTreeModel) ois.readObject());

        } catch (Exception ex) {
            //Logger.getLogger(MainFrm.class.getName()).log(Level.SEVERE, null, ex);
        }

        ((DefaultTreeModel) jTree1.getModel()).setAsksAllowsChildren(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu_TreeContext = new javax.swing.JPopupMenu();
        jMenuItem_CreateNewTestSet = new javax.swing.JMenuItem();
        jMenuItem_DeleteItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_RunSelectedTestSet = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jMenuItem_CreateNewTestSet.setText("Create New Test Set");
        jMenuItem_CreateNewTestSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CreateNewTestSetActionPerformed(evt);
            }
        });
        jPopupMenu_TreeContext.add(jMenuItem_CreateNewTestSet);

        jMenuItem_DeleteItem.setText("Delete Item");
        jMenuItem_DeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_DeleteItemActionPerformed(evt);
            }
        });
        jPopupMenu_TreeContext.add(jMenuItem_DeleteItem);
        jPopupMenu_TreeContext.add(jSeparator1);

        jMenuItem_RunSelectedTestSet.setText("Run Selected Test Set");
        jMenuItem_RunSelectedTestSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_RunSelectedTestSetActionPerformed(evt);
            }
        });
        jPopupMenu_TreeContext.add(jMenuItem_RunSelectedTestSet);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visual Test Automation Framework (VisualTAF)");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Root");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Test Sets");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Dependencies");
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setRootVisible(false);
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTree1MousePressed(evt);
            }
        });
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);
        jTree1.setDragEnabled(false);
        jTree1.setTransferHandler(new FSTransfer());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTree1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MousePressed

        if (evt.getButton() == MouseEvent.BUTTON3) {

            TreePath pathForLocation = jTree1.getPathForLocation(evt.getPoint().x, evt.getPoint().y);
            if (pathForLocation != null) {
                jTree1.setSelectionPath(pathForLocation);
            }

            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
            if (selectedNode.getParent().toString().equalsIgnoreCase("Test Sets")) {
                jMenuItem_RunSelectedTestSet.setEnabled(true);
            } else {
                jMenuItem_RunSelectedTestSet.setEnabled(false);
            }

            jPopupMenu_TreeContext.show(evt.getComponent(), evt.getX(), evt.getY());

        }

    }//GEN-LAST:event_jTree1MousePressed

    private void jMenuItem_CreateNewTestSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CreateNewTestSetActionPerformed
        String str = JOptionPane.showInputDialog(this, "Test Set Name: ", "AM Test Manager", PLAIN_MESSAGE);
        if (str == null) {
            return;
        }

        DefaultTreeModel tm = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode mtnTestSets = App.findNodeInDescendants((DefaultMutableTreeNode) tm.getRoot(), "Test Sets");

        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(str, true);
        mtnTestSets.add(newNode);

        ((DefaultTreeModel) (jTree1.getModel())).nodeStructureChanged(mtnTestSets);
        jTree1.expandPath(new TreePath(newNode.getPath()));
        jTree1.setSelectionPath(new TreePath(newNode.getPath()));
    }//GEN-LAST:event_jMenuItem_CreateNewTestSetActionPerformed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
        if (jTree1.getLastSelectedPathComponent() != null) {
            lastSelectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        }
    }//GEN-LAST:event_jTree1ValueChanged

    private void jMenuItem_RunSelectedTestSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_RunSelectedTestSetActionPerformed

        String inpValue = JOptionPane.showInputDialog(this, "Number of threads for parallel executions:", 3);
        if( inpValue == null )
            return;
        int numOfThreads = Integer.parseInt(inpValue);
    
        jTextArea1.append("Starting to run test set: '" + lastSelectedNode + "' with "+numOfThreads+" parallel threads\n");
        
        
        synchronized (lmc) {

            if (!App.lmc.validateLicenseOrTrailPeriod3()) {
                //Logger.getGlobal().severe("License or trial period invalid");
                //System.exit(1);
                int ddd = Math.round(5) / Math.min(7, 0);
            }
        }

        
        

        DefaultTreeModel tm = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode nodeDependencies = App.findNodeInDescendants((DefaultMutableTreeNode) tm.getRoot(), "Dependencies");
        Enumeration enumDependencies = nodeDependencies.children();
        while (enumDependencies.hasMoreElements()) {
            String depJarPath = ((FileItem) ((DefaultMutableTreeNode) enumDependencies.nextElement()).getUserObject()).path;
            try {
                App.addJarToClasspath(depJarPath);
            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        App.runningTestSetNode = lastSelectedNode;
        App.enTestsToRun = lastSelectedNode.children();

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        // root elements
        App.doc = docBuilder.newDocument();
        App.rootElement = App.doc.createElement("run");
        App.doc.appendChild(App.rootElement);
        App.rootElement.setAttribute("testsetname", lastSelectedNode.toString());
        App.rootElement.setAttribute("starttime", App.getCurrentTimestampForFile());

        App.globalpassedtc = 0;
        App.globalfailedtc = 0;

        App.htmlReport = new StringBuilder();
        App.htmlReport.append("<html><head>"
                + "<style>"
                + ".suite {\n"
                + "  font-size: 28px;\n"
                + "  margin-top: 10px;\n"
                + "  margin-left:10px;\n"
                + "}\n"
                + "\n"
                + "h3 {\n"
                + "  margin-left:20px;\n"
                + "  margin-top:0px;\n"
                + "}\n"
                + "\n"
                + ".suitewarning {\n"
                + "  background-color: yellow;\n"
                + "}\n"
                + "\n"
                + ".suiteallpassed {\n"
                + "  background-color: lightgreen;\n"
                + "}\n"
                + "\n"
                + ".suiteallfailed {\n"
                + "  background-color: pink;\n"
                + "}\n"
                + "\n"
                + ".testcase {\n"
                + "  margin-top: 10px;\n"
                + "  margin-left: 20px;\n"
                + "  font-size: 18px;\n"
                + "}\n"
                + "\n"
                + ".step {\n"
                + "  margin-left: 20px;\n"
                + "  font-size: 14px;\n"
                + "  font-style: italic;\n"
                + "}\n"
                + "\n"
                + ".testcase .PASSED {\n"
                + "  background-color: lightgreen;\n"
                + "   color: black  ;\n"
                + "}\n"
                + "\n"
                + ".testcase .FAILED {\n"
                + "  background-color: pink;\n"
                + "   color: black  ;\n"
                + "}\n"
                + "\n"
                + ".step .PASSED {\n"
                + "  color: green;\n"
                + "   background-color: white;\n"
                + "}\n"
                + "\n"
                + ".step .FAILED {\n"
                + "  color: red;\n"
                + "  background-color: white;\n"
                + "}"
                + "</style>"
                + "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\"></script>"
                + "</head>"
                + "<body>");

        
        for (int i = 1; i <= numOfThreads; i++) {
            new Thread() {
                public void run() {
                    App.executeTestSet();
                }
            }.start();
        }

    }//GEN-LAST:event_jMenuItem_RunSelectedTestSetActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        try (FileOutputStream fos = new FileOutputStream("data.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            oos.writeObject(jTree1.getModel());

        } catch (Exception ex) {
            //Logger.getLogger(MainFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem_DeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_DeleteItemActionPerformed

        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
        if (parentNode == jTree1.getModel().getRoot()) {
            JOptionPane.showMessageDialog(this, "you can't delete this system item!");
            return;
        }

        selectedNode.removeFromParent();
        ((DefaultTreeModel) (jTree1.getModel())).nodeStructureChanged(parentNode);

    }//GEN-LAST:event_jMenuItem_DeleteItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem_CreateNewTestSet;
    private javax.swing.JMenuItem jMenuItem_DeleteItem;
    private javax.swing.JMenuItem jMenuItem_RunSelectedTestSet;
    private javax.swing.JPopupMenu jPopupMenu_TreeContext;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}

class FSTransfer extends TransferHandler {

    public boolean importData(JComponent comp, Transferable t) {
        if (!(comp instanceof JTree)) {
            return false;
        }
        if (!t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
            return false;
        }

        JTree tree = (JTree) comp;
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        //DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        //DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        DefaultMutableTreeNode selectedNode = MainFrame.lastSelectedNode;
        try {
            java.util.List data = (java.util.List) t.getTransferData(DataFlavor.javaFileListFlavor);
            Iterator i = data.iterator();

            while (i.hasNext()) {
                File f = (File) i.next();

                if (FilenameUtils.getExtension(f.getName()).equalsIgnoreCase("xlsx")) {
                    if (!selectedNode.getParent().toString().equalsIgnoreCase("Test Sets")) {
                        JOptionPane.showMessageDialog(App.frm, "You can drop Excel files only into created Test Set node");
                        return true;
                    }
                } else if (FilenameUtils.getExtension(f.getName()).equalsIgnoreCase("jar")) {
                    if (!selectedNode.toString().equalsIgnoreCase("Dependencies")) {
                        JOptionPane.showMessageDialog(App.frm, "You can drop Jar files only to Dependencies node");
                        return true;
                    }
                } else {
                    JOptionPane.showMessageDialog(App.frm, "You can only drop Excel or Jar files into the app");
                    return true;

                }

                selectedNode.add(new DefaultMutableTreeNode(new FileItem(f.getName(), f.getPath()), false));
            }

//      model.reload();
            ((DefaultTreeModel) (tree.getModel())).nodeStructureChanged(selectedNode);
            tree.expandPath(new TreePath(selectedNode.getPath()));
            //jTree1.setSelectionPath(new TreePath(newNode.getPath()));

            return true;

        } catch (Exception ioe) {
            System.out.println(ioe);
        }
        return false;
    }

    public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
        if (comp instanceof JTree) {
            for (int i = 0; i < transferFlavors.length; i++) {
                if (!transferFlavors[i].equals(DataFlavor.javaFileListFlavor)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
